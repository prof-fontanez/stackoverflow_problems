package stackoverflow;

public class SubtractStrings
{
    public static void main(String[] args)
    {
        String A = "032";
        String B = "190";
        String str = "";
        for (int i = 0; i < A.length(); i++)
        {
            int a = Integer.parseInt(A.substring(i, i + 1));
            int b = Integer.parseInt(B.substring(i, i + 1));
            int c = a - b;
            str += String.valueOf(c < 0 ? 0 : c);
        }
        System.out.println(str);
    }
}
