package stackoverflow;

import java.util.Scanner;

public class SmallestNumber
{
    public static boolean isInteger(String num)
    {
        boolean again = false;
        try
        {
            Integer.parseInt(num);
            again = true;
        }
        catch (NumberFormatException e)
        {
            again = false;
        }
        return again;
    }

    public static void main(String[] args)
    {
        int[] intNum = new int[1000];
        int i = 0;
        String num;
        boolean repeat = false;
//        String done = "done";
        Scanner inData = new Scanner(System.in);
        System.out.println("You can enter up to 1000 integers." + "\n"
                + "Enter 'done' to finish");

        while (!repeat)
        {
            System.out.print("Int: ");
            num = inData.next();
            repeat = isInteger(num);

            if (repeat == false)
            {
                String entry = num.toUpperCase();
                boolean equals = entry.equals("DONE");

                if (equals == true)
                {
                    repeat = true;
                }
                else
                {
                    System.out
                            .println("Error: you did not enter a valid chracter. Please enter a interger or state 'done'");
                    repeat = false;
                }
            }
            else
            {
                int number = Integer.parseInt(num);
                intNum[i] = number;
                i++;
                if (i < 1000)
                {
                    repeat = false;
                }
                else
                {
                    repeat = true;
                }
            }
        }
        inData.close();

        int temp = intNum[0];
        long nano = System.nanoTime();
        for (int j = 1; j < i; j++)
        {
            if (intNum[j] < temp)
            {
                temp = intNum[j];
            }
        }
        System.out.println("Time: " + (System.nanoTime() - nano)/1000000.0 + " seconds");
        System.out.print("Smallest number: " + temp);
    }
}