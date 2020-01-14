package reen_test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 打断锁等待
 */
public class Reen3 {

    public static void main(String[] args) {

        Lock lock = new ReentrantLock();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    lock.lockInterruptibly();
                    System.out.println("线程一启动");
                    TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            try {
                lock.lockInterruptibly();
                System.out.println("线程二启动");
            } catch (InterruptedException e) {
                System.out.println("线程二被打断");
            }
        });
        t2.start();

        try {
            //正在运行的线程不能被打断
//            TimeUnit.SECONDS.sleep(3);
//            t1.interrupt();
            TimeUnit.SECONDS.sleep(3);
            t2.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
