package stackoverflow;

public class ReverseArrayDemo
{
    public static void main(String[] args)
    {

        int[] numbers = { 1, 2, 3, 4, 5, 6, 7 };

        int[] a = reverseArray(numbers);
        
        for(int i = 0; i < a.length; i++)
            System.out.println(a[i]);

    }

    public static int[] reverseArray(int[] numbers)
    {

        int[] newArray = new int[numbers.length];
        for (int i = numbers.length -1, j = 0; i >= 0; i--, j++)
        {
           newArray[i] = numbers[j];
        }
        return newArray;
    }
}
