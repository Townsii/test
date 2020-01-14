package sync_test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * wait 线程休眠 释放锁
 * notify 唤醒随机睡眠线程
 * notifyAll 唤醒所有睡眠线程
 */
public class Volatile5 {
    private List list = new ArrayList();

    private void ladd(Object o) {
        list.add(o);
    }

    private int lsize() {
        return list.size();
    }

    public static void main(String[] args) {
        Volatile5 vol = new Volatile5();
        final Object o = new Object();
        new Thread(() -> {
            synchronized (o) {
                System.out.println("开始");
                if (vol.lsize() != 5) {
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + "结束");
                o.notify();
            }
        }, "线程二").start();

        new Thread(() -> {
            synchronized (o) {
                for (int i = 0; i < 10; i++) {
                    vol.ladd(i);
                    System.out.println(vol.lsize());

                    if (vol.lsize() == 5) {
                        o.notify();
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
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
