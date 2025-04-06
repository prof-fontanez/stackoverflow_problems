package stackoverflow.atomic;

public class Derived extends Thread
{
    String name;
    public Derived(String name){
        this.name = name;
    }
    public void run() {
        Singleton a = Singleton.getInstance();
        for (int i = 0; i < 10; i++) {
            System.out.println("Current thread: "+ name + a.test());
        }
    }
}
