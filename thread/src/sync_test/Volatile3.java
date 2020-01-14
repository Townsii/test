package sync_test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * java自带原子类和原子方法
 */
public class Volatile3 {

    private AtomicInteger count = new AtomicInteger(0);

    void m() {
        for (int i = 0; i < 10000; i++) {
            count.incrementAndGet();
        }
    }

    public static void main(String[] args) {
        Volatile3 volatile3 = new Volatile3();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(volatile3::m, "thread" + i));
        }
        for (Thread t : threads) {
            t.start();
        }
        //join方法阻塞线程直到计算完成
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(volatile3.count);
    }

}
