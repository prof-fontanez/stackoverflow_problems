package stackoverflow;

import java.util.InputMismatchException;
import java.util.Scanner;

public class IntToStringToCharDemo
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please type a number between 0 and 999 OR type -1 to exit:  ");
        int number = -1;
        try
        {
            number = scanner.nextInt();
            String numString = String.valueOf(number);
            char[] digits = numString.toCharArray();
            System.out.println(numString);
            for (char digit : digits)
            {
                System.out.println(digit);
            }
        }
        catch (InputMismatchException e)
        {
            System.err.println("Entered string is not numeric. Exiting program...");
        }
        finally
        {
            scanner.close();
        }
    }
}
