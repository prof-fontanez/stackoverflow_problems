package stackoverflow;

import javax.swing.JOptionPane;

public class DoWhileDemo
{
    public static void main(String[] args)
    {
        // Defining the variables in main method
        int inputNumber = 0;
        boolean repeat = false;

        // Creating the array and checking for negative or no numbers using
        // do..while and if..else
        do
        {
            String aStr = JOptionPane.showInputDialog(null,
                    "How many numbers would you like to be averaged?");
            try
            {
                inputNumber = Integer.parseInt(aStr);
            }
            catch (NumberFormatException e)
            {
                JOptionPane.showMessageDialog(null,
                        "Input must be a numeric string. Try again",
                        "ERROR: Invalid input", JOptionPane.ERROR_MESSAGE);
                repeat = true;
                continue;
            }

            if (inputNumber <= 0)
            {
                JOptionPane.showMessageDialog(null,
                        "Input must be a number greater than zero. Try again.",
                        "ERROR: Invalid input", JOptionPane.ERROR_MESSAGE);
                repeat = true;
            }
            else
            {
                double[] array = new double[inputNumber];
                displayAverage(average(array));
            }
        } while (repeat);
    } // end main

    // Creating a method called "average" that calculates and returns the
    // average to main
    public static double average(double[] methodArray)
    {
        // Defining variables in average method
        int index;
        double total = 0;
        double average;

        // Taking user inputed numbers and adding them up
        for (index = 0; index < methodArray.length; index++)
        {
            String bStr = JOptionPane.showInputDialog(null, "Enter number "
                    + (index + 1));
            methodArray[index] = Double.parseDouble(bStr);

            total = total + methodArray[index];
        }
        // Calculating the average
        average = total / index;
        return average;
    } // end average method

    // Creating a method called "displayAverage" that displays the average in a
    // dialog box
    public static void displayAverage(double returnedAverage)
    {
        JOptionPane.showMessageDialog(null,
                "The average of all your numbers is " + returnedAverage);
    }
}
