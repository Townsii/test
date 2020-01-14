package concurrent_test;

import java.text.DecimalFormat;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * ConcurrentLinkedDeque线程安全队列
 */
public class Concurrent1 {
    static ConcurrentLinkedQueue<String> list = new ConcurrentLinkedQueue<String>();


    public static void main(String[] args) {
        for (int i = 0; i < 100; i++)
            list.add(String.valueOf(i));
        for(int i = 0;i<10;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        //poll之后只有判断，没有拿取操作，因此线程安全，不会因为线程被打断拿越界值
                        String poll = list.poll();
                        if (poll == null)
                            break;
                        else
                            System.out.println(poll);
                    }
                }
            }).start();
        }
    }
}
