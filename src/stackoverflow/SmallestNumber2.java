package stackoverflow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SmallestNumber2
{

    public static void main(String[] args)
    {
        List<Integer> numbers = new ArrayList<Integer>(1000);
        Scanner inData = new Scanner(System.in);
        System.out.println("You can enter up to 1000 integers." + "\n"
                + "Enter 'done' to finish");
        String input = "";
        do
        {
            input = inData.next();
            try
            {
                numbers.add(Integer.parseInt(input));
            }
            catch(NumberFormatException e)
            {
                System.out.println(input + " is not a number. Skipping...");
            }
        } while (!input.equalsIgnoreCase("done"));
        
        long nano = System.nanoTime();
        Collections.sort(numbers);
        System.out.println("Time: " + (System.nanoTime() - nano)/1000000.0 + " seconds");
        inData.close();
        System.out.println("Smallest number: " + numbers.get(0));
    }

}
