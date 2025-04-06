package stackoverflow;

import stackoverflow.DegreeConvertionUtility.Scale;

public class DegreeConvertionTest
{

    public static void main(String[] args)
    {
        DegreeConvertionUtility temp = DegreeConvertionUtility.create(
                28, Scale.valueOf("Celsius"));
        System.out.println(temp.convertTo(Scale.valueOf("Fahrenheit")));
    }
}
