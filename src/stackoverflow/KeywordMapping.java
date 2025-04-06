package stackoverflow;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class KeywordMapping implements Comparable<KeywordMapping> {

    private final String keyword;
    private TreeSet<String> titleIds = new TreeSet<String>();
    private int frequency;

    public KeywordMapping(String keyword, String titleId) {
        this.keyword = keyword;
        titleIds.add(titleId);
    }

    public String getKeyword () {
        return keyword;
    }

    public int getTitleCount () {
        return titleIds.size();
    }

    public void addTitleId (String titleId) {
        titleIds.add(titleId);
    }

    public String getFirstTitleId () {
        return titleIds.first();
    }

    public String getTitleIdAtPosition (int pos) {
        AtomicInteger counter = new AtomicInteger(1);
        AtomicReference<String> item = new AtomicReference<>();
        titleIds.forEach(titleId -> {
            if (counter.get() == pos) {
                item.set(titleId);
            }
            counter.getAndIncrement();
        });
        return item.get();
    }

    public void incrementFrequency(String keyword) {
        if (this.keyword.equals(keyword)) {
            frequency++;
        }
    }

    public int getFrequency() {
        return frequency;
    }

    public boolean containsTitle(String titleId) {
        return titleIds.contains(titleId);
    }

    @Override
    public int hashCode () {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( (keyword == null) ? 0 : keyword.hashCode());
        result = prime * result + ( (titleIds == null) ? 0 : titleIds.hashCode());
        return result;
    }

    @Override
    public boolean equals (Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        KeywordMapping other = (KeywordMapping) obj;
        if (keyword == null) {
            if (other.keyword != null) return false;
        } else if (!keyword.equals(other.keyword)) return false;
        if (titleIds == null) {
            if (other.titleIds != null) return false;
        } else if (!titleIds.equals(other.titleIds)) return false;
        return true;
    }

    @Override
    public String toString () {
        return "KeywordMapping [keyword=" + keyword + ", titleIds=" + titleIds + ", frequency=" + frequency
                + "]";
    }

    @Override
    public int compareTo (KeywordMapping o) {
        return COMPARATOR.compare(this, o);
    }

    private static final Comparator<KeywordMapping> COMPARATOR =
            Comparator.comparing( (KeywordMapping keyMapping) -> keyMapping.keyword);

    public static void main (String[] args) {
        List<String> titles = List.of("title2: canon camera canon",
                "title3: wireless mouse",
                "title1: canon photo printer",
                "title4: wireless charger", "title5: mouse trap");

        MasterMap mappings = new MasterMap(); // A class wrapping TreeMap<String, KeywordMapping> mappings (the code is shown later on)

        for (String title : titles) {
            String[] tokens = title.split(": ");
            Set<String> keywords = new HashSet<>(Arrays.asList(tokens[1].split(" ")));
            for (String keyword : keywords) {
                KeywordMapping km = mappings.get(keyword); // don't create duplicate keyword mapping objects
                if (km == null) {
                    km = new KeywordMapping(keyword, tokens[0]);
                }
                km.addTitleId(tokens[0]);
                km.incrementFrequency(keyword);
                mappings.put(keyword, km); // update existing or new keyword mapping entry
            }
        }
        System.out.println(mappings);
        System.out.println("First entry: " + mappings.firstMapping());
        System.out.println("Third entry: " + mappings.getMappingAtPosition(3));
        System.out.println("First title in first entry: " + mappings.firstMapping().getFirstTitleId());
        System.out.println("Second title in third entry: " + mappings.getMappingAtPosition(3).getTitleIdAtPosition(2));
        System.out.println("Second title in second entry: " + mappings.getMappingAtPosition(2).getTitleIdAtPosition(2));
    }
}