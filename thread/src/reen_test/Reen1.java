package reen_test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 自定义reentrantlock,互斥锁，重入锁
 * sync是非公平锁 reen true是公平锁,false是非公平锁
 * 非公平锁按竞争，效率高 公平锁按等待时间，效率低
 */
@SuppressWarnings("all")
public class Reen1 {
    Lock lock = new ReentrantLock();

    void m() {
        lock.lock();
        try {
            while (true) {
                System.out.println(Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //reentrantlock必须手工释放锁
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Reen1 reen1 = new Reen1();
        new Thread(reen1::m, "线程一").start();
        new Thread(reen1::m, "线程二").start();
    }

}
