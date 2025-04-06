package stackoverflow.atomic;

public class Singleton
{
    private static Singleton sin;
    private static volatile int count;
    static{
        sin = new Singleton();
        count = 0;
    }
    private Singleton(){

    }
    public static Singleton getInstance(){
        return sin;
    }

    public synchronized String test(){
        count++;
        return ("Counted increased!" + count);
    }
}
