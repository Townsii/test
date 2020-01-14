package collection;

import java.sql.SQLOutput;

/**
 * 自定义实现ArrayList1
 * @author town
 */
public class ArrayList1 {
    private Object[] elem;
    private int size = 0;
    private static final int DEFALT_CAPACITY = 10;

    public ArrayList1(){
        elem = new Object[DEFALT_CAPACITY];
    }

    public ArrayList1(int capacity){
        elem = new Object[capacity];
    }

    /**
     * 为数组添加内容并实现扩容
     * @param obj 添加的内容
     */
    public void add(Object obj){
        if(size>=elem.length){
            Object[] newElem = new Object[(int)(1.5*elem.length)];
            System.arraycopy(elem,0,newElem,0,size);
            elem = newElem;
            }
        elem[size++] = obj;
    }

    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer();
        for(Object obj:elem){
            sb.append(obj);
        }
        return sb.toString();
    }

    public static void main(String[] args){
        ArrayList1 list1 = new ArrayList1();
        for(int i=0;i<30;i++)
            list1.add(i);
        System.out.println(list1);
    }
}
