package map;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest1 {

    //哈希桶
    private Entry[] table;
    private int size;

    public HashMapTest1(){
        table = new Entry[16];
    }

    public void put(Object key,Object value){
        Entry entry = new Entry();
        entry.hash = myHashCode(key.hashCode(),table.length);
        entry.key = key;
        entry.value = value;
        entry.next = null;
    }

    private int myHashCode(int v,int length){
        return v&(length-1);
    }


    public static void main(String[] args) {

    }
}
