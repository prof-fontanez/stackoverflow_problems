package stackoverflow;

public class Primitives
{

    public static void main(String[] args)
    {
        double [][] matrix1 = {{1.00, 98.00, 95.00, 97.00}, {2.00, 97.00, 96.00, 96.00}, {3.00, 94.00, 98.00, 98.00}};
        double [][] matrix2 = {{0, 0, 0, 0}, {0, 0, 0, 0}, {19.33, 38.60, 57.93, 0}};
        double sum;
        for (int c = 1; c < matrix1[0].length; c++)
        {
            sum = 0;
            for (int r = 0; r < matrix1.length; r++)
            {
                sum = sum + matrix1[r][c];
//                matrix2[2][r] = sum / matrix1.length;
                System.out.print(sum + "\t");
            }
            matrix2[2][c] = sum / matrix1.length;
            System.out.println();
        }
    }
}
