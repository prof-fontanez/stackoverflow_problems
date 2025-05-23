package stackoverflow;

import java.util.Scanner;

public class PassingTrains
{
    static int currentTime = 9, firstDistance = 0, secondDistance = 0,
            firstSpeed = 40, secondSpeed, elapsedTime;
    static Scanner input = new Scanner(System.in);

    public static String passTime()
    {
        System.out.print("Enter the speed of the passenger train: ");
        secondSpeed = input.nextInt();
        while (currentTime < 11)
        {
            firstDistance += firstSpeed;
            currentTime++;
        }
        while (firstDistance > secondDistance)
        {
            firstDistance += firstSpeed;
            secondDistance += secondSpeed;
            elapsedTime++;
        }
        currentTime += elapsedTime % 24;
        currentTime = (currentTime > 12) ? currentTime - 12 : currentTime;
        
        if (firstDistance == secondDistance)
        {
            return ("at " + currentTime);
        }
        else
        {
            return ("between " + ((currentTime - 1 == 0) ? 12 : currentTime) + " o'clock and " + currentTime);
        }
    }

    public static void main(String[] args)
    {
        System.out.println("The passenger train passed the freight train at "
                + passTime() + " o'clock");
        System.out.println("The freight train was traveling " + firstSpeed
                + " mph");
        System.out.println("The passenger train was traveling at "
                + secondSpeed + " mph");
    }
}