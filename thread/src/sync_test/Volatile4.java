package sync_test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 多个原子类同时操作不一定保持原子性
 */
public class Volatile4 {
    private AtomicInteger count = new AtomicInteger(0);

    void m() {
        for (int i = 0; i < 10000; i++) {
            if (Integer.parseInt(String.valueOf(count)) < 6666)
                count.incrementAndGet();
        }
    }

    public static void main(String[] args) {
        Volatile4 volatile4 = new Volatile4();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(volatile4::m, "thread" + i));
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

        System.out.println(volatile4.count);
    }
}
