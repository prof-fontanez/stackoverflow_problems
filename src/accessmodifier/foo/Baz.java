package accessmodifier.foo;

public class Baz
{
    public static void main (String... args)
    {
        Baz baz = new Baz();
//        baz.doSomething(); // Compiling error: Method not defined for this class.
    }
}
