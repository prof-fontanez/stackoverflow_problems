package stackoverflow;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegExSplit
{

    public static void main(String[] args)
    {
        String str = "098678123";
        String regex = "(\\d{3})(\\d{3})(\\d{3})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        if (matcher.find())
        {
            for(int i = 1; i <=3; i++)
                System.out.println(matcher.group(i));
        }
    }
}
