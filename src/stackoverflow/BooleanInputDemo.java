package stackoverflow;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BooleanInputDemo
{

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        Boolean answer = null;
        do
        {
            System.out.println("Enter either true or false");
            try
            {
                answer = input.nextBoolean();
            }
            catch(InputMismatchException e)
            {
                System.out.println("ERROR: The input provided is not a valid boolean value. Try again...");
                input.next(); // flush the stream
            }
        } while(answer == null);
        input.close();
    }
}
