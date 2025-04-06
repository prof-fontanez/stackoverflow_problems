package stackoverflow;

import java.io.IOException;

public class Classes2
{
    public static void main(String[] args) throws IOException
    {
        Dot dot1 = new Dot();
        Dot dot2 = new Dot();
        boolean result = dot1.checkDotSymmetry(dot2);
        if (result) System.out.println("Dots are located symmetrical");
        else System.out.println("Dots are NOT located symmetrical");
        
    }

}
