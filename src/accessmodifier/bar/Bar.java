package accessmodifier.bar;

import accessmodifier.foo.Foo;

public class Bar extends Foo
{
    public static void main (String... args)
    {
        Bar bar = new Bar();
        bar.doSomething();
    }
}
