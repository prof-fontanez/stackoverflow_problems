package stackoverflow.atomic;

public class Java
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Derived d1 = new Derived("d1");
        d1.start();
        Derived d2 = new Derived("d2");
        d2.start();
        Derived d3 = new Derived("d3");
        d3.start();

    }
}
