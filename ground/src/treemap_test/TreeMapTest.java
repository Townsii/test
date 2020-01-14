package treemap_test;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapTest {
    public static void main(String[] args) {
        Map<Salary,String> treeMap1 = new TreeMap<>();
        treeMap1.put(new Salary(1,"b",6000),"a");
        treeMap1.put(new Salary(2,"b",5000),"b");
        treeMap1.put(new Salary(3,"b",5000),"c");
        for(Salary i:treeMap1.keySet()) {
            System.out.println(i.toString()+"——"+treeMap1.get(i));
        }
    }

}
