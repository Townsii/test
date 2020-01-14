package sync_test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest {
    private List list = new ArrayList();

    private void ladd(Object o) {
        list.add(o);
    }

    private int lsize() {
        return list.size();
    }

    public static void main(String[] args) {
        CountDownLatchTest vol = new CountDownLatchTest();
        CountDownLatch latch = new CountDownLatch(1);
        final Object o = new Object();
        new Thread(() -> {

                System.out.println("开始");
                if (vol.lsize() != 5) {
                    try {
                        latch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + "结束");
        }, "线程二").start();

        new Thread(() -> {
            synchronized (o) {
                for (int i = 0; i < 10; i++) {
                    vol.ladd(i);
                    System.out.println(vol.lsize());

                    if (vol.lsize() == 5) {
                        latch.countDown();
                        System.out.println("激活");
                    }
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "线程一").start();


    }
}
