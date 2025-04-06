package stackoverflow;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Solution
{
    public static Integer[] convert(int[] chars)
    {
        Integer[] copy = new Integer[chars.length];
        Arrays.fill(copy, 0);
        for (int i = 0; i < copy.length; i++)
        {
            copy[i] = Integer.valueOf(chars[i]);
        }
        return copy;
    }

    public static void main(String[] args)
    {
        /*
         * Enter your code here. Read input from STDIN. Print output to STDOUT.
         * Your class should be named Solution.
         */
        int x, max;
        int a[], sum[], fib[];
        Scanner in = new Scanner(System.in);
        System.out.print("Enter an even integer value: ");
        x = in.nextInt();
        a = new int[x];
        sum = new int[x];
        for (int i = 0; i < x; i++)
        {
            System.out.print("Enter more digits: ");
            a[i] = in.nextInt();
        }
        Integer[] b = convert(a);
        max = Collections.max(Arrays.asList(b));
        fib = new int[max];
        if (max > 1)
        {
            fib[0] = 1;
            fib[1] = 1;
        }
        for (int i = 2; i < max; i++)
        {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        for (int i = 0; i < x; i++)
        {
            for (int j = 0; fib[j] < a[i]; j++)
            {
                if (fib[j] % 2 == 0)
                    sum[i] = sum[i] + fib[j];
            }
        }
        for (int i = 0; i < x; i++)
        {
            System.out.println(sum[i]);
        }
        in.close();
    }

    public static long fibonacci(long number)
    {
        if ((number == 0) || (number == 1)) // base cases
            return number;
        else
            // recursion step
            return fibonacci(number - 1) + fibonacci(number - 2);
    }

}
