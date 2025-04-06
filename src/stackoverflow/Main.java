package stackoverflow;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Main
{

    public static void main(String[] args)
    {
        List<String> list = new ArrayList<String>();
        Set<String> set = new LinkedHashSet<String>();
        
        String foo = "foo";
        String bar = "bar";
        
        list.add(foo);
        list.add(bar);
        list.add(foo);
        list.add(bar);
        
        set.addAll(list); // duplicates gone
        list.removeAll(list);
        list.addAll(set);

    }
}
