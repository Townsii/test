package reen_test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * tryLock 尝试拿锁
 */
@SuppressWarnings("all")
public class Reen2 {

    Lock lock = new ReentrantLock();

    void m() {
        try {
            lock.tryLock(3,TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            int i = 0;
            while (i<10) {
                System.out.println(Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(1);
                i++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //reentrantlock必须手工释放锁
            lock.unlock();
        }
    }

    void m2(){
        try {
            boolean flag = lock.tryLock(20,TimeUnit.SECONDS);
            if(flag)
                System.out.println("拿到锁了");
            System.out.println("m2"+Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Reen2 reen2 = new Reen2();
        new Thread(reen2::m, "线程一").start();
        new Thread(reen2::m2, "线程二").start();
    }

}
