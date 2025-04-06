package stackoverflow;

import java.util.Scanner;

public class ScannerExample
{

    public static void main(String... args)
    {
        String[] lines =
        { "GET /tiny.html HTTP/1.1", "", "Host: Connection: close"};
        Scanner scn = new Scanner(lines[0]);
        String command = scn.next();
        String fileName = scn.next();
        String protocol = scn.next();
        Scanner scn2 = new Scanner(lines[1]);
        String host = scn2.next();
        String hostline = scn2.next();
        new Scanner(lines[2]);

        if (protocol.equals("HTTP/1.1") && hostline.isEmpty())
        {
            System.out.println("fail");
        }
        else
        {
            System.out.println("success");
        }
    }
}
