package concurrent_test;


import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class ConcurrentMapTest {
    //最常用的线程安全HashMap
    Map map1 = new ConcurrentHashMap();


    //线程安全的跳表Map，应用于多线程且需要排序
    Map map2 = new ConcurrentSkipListMap();

    //线程安全，不允许有空值，效率较低，不常用
    Map map3 = new Hashtable();

    //利用Collections.synchronized给普通HashMap加锁
    static {
        Map map = new HashMap();
        Map map4 = Collections.synchronizedMap(map);
    }

    public static void main(String[] args) {

    }
}
