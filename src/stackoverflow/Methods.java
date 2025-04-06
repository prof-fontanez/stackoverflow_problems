package stackoverflow;

import java.util.Scanner;

public class Methods
{
    public static void main(String[] args)
    {

        int[] numbrs;
        numbrs = new int[25];
        int i = 0;
        System.out.println();
        populateArray(numbrs, numbrs.length);
        System.out.println("\n********** the array reversed is **********\n");
        for (i = numbrs.length - 1; i >= 0; i--)
            System.out.println(numbrs[i]);

        System.out.println("Highest value: " + max(numbrs));
        System.out.println("\n***** end of Array01.java *****");
    } // end of main method

    /* ********************************************************
     * Pre Condition: an array of n integers where n is given.
     * 
     * Post Condition: an array populated with randomly generated integers in
     * the range of 1 to limit specified by the user.
     * *******************************************************
     */

    public static void populateArray(int[] arry, int lm)
    {
        System.out.print("Enter the upper limit of random numbers...");
        Scanner kBd = new Scanner(System.in);
        int lim = kBd.nextInt();
        System.out.println();
        for (int i = 0; i < lm; i++)
        {
            arry[i] = getRandomInt(lim);
            System.out.println(arry[i]);
        }
        kBd.close();
    } // end of populateArray method

    /* ********************************************************
     * Pre Condition: an integer for the upper limit of the random number to
     * generate. Post Condition: an integer in the range of 1 to limit
     * *******************************************************
     */

    public static int getRandomInt(int limit)
    {
        return (1 + (int) (Math.random() * limit));

    } 

    public static int max(int[] array)
    {
        int highest = array[0];
        for (int i = 1; i < array.length; i++)
            if (array[i] > highest)
                highest = array[i];
        return highest;
    }
}
