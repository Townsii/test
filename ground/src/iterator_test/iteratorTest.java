package iterator_test;



import java.util.*;

public class iteratorTest {

    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        list.add("a");
//        list.add("b");
//        list.add("c");
//
//        for(Iterator<String>ite = list.iterator();ite.hasNext();){
//            String temp = ite.next();
//            System.out.println(temp);
//        }



//        Set<String> set = new HashSet<>();
//        set.add("d");
//        set.add("e");
//        set.add("f");
//
//        for(Iterator<String>ite2 = set.iterator();ite2.hasNext();){
//            System.out.println(ite2.next());
//        }
//

        Map<Integer,String> map = new HashMap<>();
        map.put(1,"g");
        map.put(2,"h");
        map.put(3,"i");

        Set<Map.Entry<Integer, String>> entries = map.entrySet();

        for(Iterator<Map.Entry<Integer, String>> iterator = entries.iterator(); iterator.hasNext();){
            Map.Entry<Integer,String> temp = iterator.next();
            System.out.println(temp.getKey()+"——"+temp.getValue());
        }

        Set<Integer> integers = map.keySet();

        for(Iterator<Integer> iterator = integers.iterator();iterator.hasNext();){
            Integer next = iterator.next();
            System.out.println(next+map.get(next));
        }


    }




}
