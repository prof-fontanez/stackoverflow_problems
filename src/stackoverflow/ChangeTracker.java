package stackoverflow;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChangeTracker
{
    public static void main(String[] args)
    {
        List<Integer> currencies = new ArrayList<Integer>(13);
        currencies.add(0);
        currencies.add(1);
        currencies.add(5);
        currencies.add(10);
        currencies.add(25);
        currencies.add(50);
        currencies.add(100);
        currencies.add(200);
        currencies.add(500);
        currencies.add(1000);
        currencies.add(2000);
        currencies.add(5000);
        currencies.add(10000);
        
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an amount (in pennies): ");
        int amount = input.nextInt();

        double d = amount/100d;
        System.out.printf("$%.2f equal %d pennies %n", d, amount );

        int currentIndex = currencies.size() - 1;
        while (currencies.get(currentIndex) >= amount)
        {
            currentIndex--;
        }
        
        System.out.println("The largest currency that fits the input is " + currencies.get(currentIndex));

        input.close();
    }
    
    public static int calculate(int amount)
    {
        int result = 0;
        if (amount == 0)
        {
            return amount;
        }
        // Figure out the largest currency that fits in amount and subtract it
        // from amount. Store the result and pass it recursively
        return calculate(result);
    }
}
