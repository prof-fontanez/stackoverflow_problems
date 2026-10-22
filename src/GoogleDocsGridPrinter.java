import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Reads a Google Doc containing a table of (x-coordinate, Character, y-coordinate)
 * rows and prints the resulting character grid to the console.
 *
 * Coordinate system: x grows to the right, y grows upward, (0, 0) is the
 * bottom-left corner. Unspecified positions are filled with a space.
 *
 * Requirements: Java 16+ (uses records and java.net.http). No external libraries.
 * The doc must be readable without signing in, i.e. either
 *   - shared as "Anyone with the link can view" (any /document/d/<id>/... URL), or
 *   - published to the web (File > Share > Publish to web, a /pub URL).
 */
public class GoogleDocsGridPrinter {

    /** One entry from the table. */
    record Cell(int x, int y, String character) {}

    private static final PrintStream OUT =
            new PrintStream(new FileOutputStream(FileDescriptor.out), true, StandardCharsets.UTF_8);

    private static final Pattern DOC_ID = Pattern.compile("/document/(?:u/\\d+/)?d/(?:e/)?([A-Za-z0-9_-]+)");
    private static final Pattern ROW = Pattern.compile("(?is)<tr[^>]*>(.*?)</tr>");
    private static final Pattern TABLE_CELL = Pattern.compile("(?is)<t[dh][^>]*>(.*?)</t[dh]>");
    private static final Pattern TAG = Pattern.compile("(?s)<[^>]*>");
    private static final Pattern ENTITY = Pattern.compile("&(#[xX][0-9a-fA-F]+|#\\d+|[a-zA-Z]+);");
    private static final Map<String, String> NAMED_ENTITIES = Map.of(
            "amp", "&", "lt", "<", "gt", ">", "quot", "\"", "apos", "'", "nbsp", " ");

    /**
     * The required entry point: takes the Google Doc URL, downloads the doc,
     * parses the coordinate table, and prints the character grid.
     */
    public static void printGridFromGoogleDoc(String docUrl) throws IOException, InterruptedException {
        String html = fetch(toHtmlUrl(docUrl));
        List<Cell> cells = parseCells(html);
        if (cells.isEmpty()) {
            throw new IllegalStateException("No coordinate rows found in the document. Is the URL correct and is the doc publicly viewable?");
        }
        OUT.print(renderGrid(cells));
        OUT.flush();
    }

    /** Converts any Google Doc URL into one that returns the doc as HTML without authentication. */
    static String toHtmlUrl(String docUrl) {
        String url = docUrl.trim();
        // A "Publish to web" link (/document/d/e/<id>/pub) already serves HTML.
        if (url.contains("/pub")) {
            return url;
        }
        Matcher m = DOC_ID.matcher(url);
        if (!m.find()) {
            throw new IllegalArgumentException("Not a recognizable Google Docs URL: " + docUrl);
        }
        return "https://docs.google.com/document/d/" + m.group(1) + "/export?format=html";
    }

    /** Downloads the page body as text, following Google's redirects. */
    static String fetch(String url) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.NORMAL)
                .connectTimeout(Duration.ofSeconds(15))
                .build();
        HttpRequest request = HttpRequest.newBuilder(URI.create(url))
                .timeout(Duration.ofSeconds(30))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));
        if (response.statusCode() != 200) {
            throw new IOException("HTTP " + response.statusCode() + " fetching " + url
                    + " (make sure the doc is shared as 'Anyone with the link' or published to the web)");
        }
        return response.body();
    }

    /**
     * Extracts every table row whose first and third cells are integers.
     * The header row ("x-coordinate | Character | y-coordinate") is skipped automatically.
     */
    static List<Cell> parseCells(String html) {
        List<Cell> cells = new ArrayList<>();
        Matcher rowMatcher = ROW.matcher(html);
        while (rowMatcher.find()) {
            List<String> columns = new ArrayList<>();
            Matcher cellMatcher = TABLE_CELL.matcher(rowMatcher.group(1));
            while (cellMatcher.find()) {
                columns.add(cellText(cellMatcher.group(1)));
            }
            if (columns.size() < 3) {
                continue;
            }
            try {
                int x = Integer.parseInt(columns.get(0).trim());
                int y = Integer.parseInt(columns.get(2).trim());
                String character = columns.get(1).strip();
                if (character.isEmpty()) {
                    character = " ";
                }
                if (x < 0 || y < 0) {
                    throw new IllegalStateException("Negative coordinate (" + x + ", " + y + ") in document");
                }
                cells.add(new Cell(x, y, character));
            } catch (NumberFormatException headerOrJunk) {
                // Not a data row; ignore.
            }
        }
        return cells;
    }

    /** Strips HTML tags from a table cell and decodes entities, leaving plain text. */
    static String cellText(String cellHtml) {
        return decodeEntities(TAG.matcher(cellHtml).replaceAll("")).replace('\u00A0', ' ');
    }

    /** Decodes numeric (&#9608; / &#x2588;) and common named HTML entities. */
    static String decodeEntities(String text) {
        Matcher m = ENTITY.matcher(text);
        StringBuilder sb = new StringBuilder();
        while (m.find()) {
            String entity = m.group(1);
            String replacement;
            if (entity.startsWith("#x") || entity.startsWith("#X")) {
                replacement = Character.toString(Integer.parseInt(entity.substring(2), 16));
            } else if (entity.startsWith("#")) {
                replacement = Character.toString(Integer.parseInt(entity.substring(1)));
            } else {
                replacement = NAMED_ENTITIES.getOrDefault(entity, m.group(0));
            }
            m.appendReplacement(sb, Matcher.quoteReplacement(replacement));
        }
        m.appendTail(sb);
        return sb.toString();
    }

    /**
     * Builds the grid text. Rows are printed from the highest y down to y = 0,
     * so (0, 0) appears in the bottom-left corner. Gaps are spaces.
     */
    static String renderGrid(List<Cell> cells) {
        int maxX = cells.stream().mapToInt(Cell::x).max().orElse(0);
        int maxY = cells.stream().mapToInt(Cell::y).max().orElse(0);

        String[][] grid = new String[maxY + 1][maxX + 1];
        for (String[] row : grid) {
            java.util.Arrays.fill(row, " ");
        }
        for (Cell c : cells) {
            grid[c.y()][c.x()] = c.character();
        }

        StringBuilder sb = new StringBuilder();
        for (int y = maxY; y >= 0; y--) {
            for (int x = 0; x <= maxX; x++) {
                sb.append(grid[y][x]);
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        printGridFromGoogleDoc("https://docs.google.com/document/d/e/2PACX-1vSvM5gDlNvt7npYHhp_XfsJvuntUhq184By5xO_pA4b_gCWeXb6dM6ZxwN8rE6S4ghUsCj2VKR21oEP/pub");
    }
}
