package stackoverflow;

public class ConstantDemo
{

    public static void main(String[] args)
    {
        ConstantDemo demo = new ConstantDemo();        
        for (int i = 1; i <=12; i++)
            System.out.println("7 times " + i + " equals " + demo.timesSeven(i));
    }
    
    public int timesSeven(int number)
    {
        final int x = 7;
        return number * x;
    }

}
