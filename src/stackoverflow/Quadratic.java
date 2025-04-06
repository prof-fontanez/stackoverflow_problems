package stackoverflow;

import java.util.Scanner;

public class Quadratic
{

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a, b, and c coefficients (separated by spaces): ");
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();
        double result1 = (-b + Math.sqrt((b*b) - (4*a*c)))/(2*a);
        double result2 = (-b - Math.sqrt((b*b) - (4*a*c)))/(2*a);
        System.out.println("Result: " + result1 + ", "+ result2);
        input.close();
    }

}
