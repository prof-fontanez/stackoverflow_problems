import java.util.Iterator;
import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

public class RandomText
{
    public static void main(String[] args)
    {
        Random rand = new Random();
        SortedSet<Integer> numbers = new TreeSet<Integer>();

        for (int i = 0; i < 20; i++)
        {
            int randomInt = rand.nextInt(10000);
            System.out.println("Generated Number: " + randomInt);
            numbers.add(randomInt);
        }

        System.out.println("*************************");
        
        System.out.println("Smallest Number: " + numbers.first()); // O(1) operation
        System.out.println("Largest Number: " + numbers.last()); // O(1) operation

        System.out.println("*************************");
        Iterator<Integer> iter = numbers.iterator();
        while (iter.hasNext())
        {
            System.out.println("Added Values: " + iter.next());
        }
    }
}
