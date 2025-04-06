package stackoverflow;

public class ArrayOfStrings
{

    public static void main(String[] args)
    {
        String str = "This is a long string";
        String[] arr = new String[str.length()];

        for(int i = 0; i < arr.length; i++)
        {
            arr[i] = str.substring(i, i+1);
        }
    }
}
