package stackoverflow;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Scantest
{
    public static void main(String[] args) throws IOException
    {

        Scanner file = null;

        try
        {
            file = new Scanner(new BufferedReader(new FileReader("foo.txt")));

            while (file.hasNextLine())
            {
                System.out.println(file.nextLine());
            }
        }
        finally
        {
            if (file != null)
            {
                file.close();
            }
        }
    }
}