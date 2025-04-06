package linkedin;

public class TruncateInteger
{

    public static void main(String[] args)
    {
        long i = Integer.MAX_VALUE;
        i += 0.0f;
        int j = (int) i;
        System.out.println(j == Integer.MAX_VALUE);
        System.out.println(j == Integer.MIN_VALUE);
    }

}
