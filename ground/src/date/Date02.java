package date;

import java.util.*;

public class Date02 {
    public static void main(String[] args){
        Date now = new Date();
        System.out.println(now.toString());
        System.out.println(now.getTime());
        Date zero = new Date(0);
        System.out.println("用0作为构造方法，得到的日期是:"+zero);
    }
}
