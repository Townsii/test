package sync_test;
/**
 * volatile
 */

import java.util.concurrent.TimeUnit;

public class Volatile1 {
     /*volatile*/ int flag = 1;
     int i =0;

     //此处m方法内无函数或只有写不会终止
    //有读方法或者在属性前加volatile会终止
    //说明volatile和读都会造成缓存过期更新
    void m() {
        Long start = System.currentTimeMillis();
        while (flag == 1) {
            i++;
            System.out.println(i);
        }
        System.out.println("end"+"---"+(System.currentTimeMillis()-start));
    }

    public static void main(String[] args){
        Volatile1 vol = new Volatile1();
        new Thread(vol::m).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        vol.flag = 0;

    }
}
