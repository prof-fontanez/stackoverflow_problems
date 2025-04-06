package stackoverflow;

public class TwoDimensionArrayDemo
{
    public static void main(String... args)
    {
        int[][] array = {{1, 2, 3, 4},{5, 6, 7, 8}};
        
        for(int col = 0; col < 4; col++)
        {
            double sum = 0;
            int row = 0;
            while (row  < array.length)
            {
                sum+=array[row++][col];
            }
            System.out.println("Average of values stored in column " + col + " is " + sum / array.length);
        }
    }
}
