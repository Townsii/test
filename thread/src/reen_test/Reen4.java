package reen_test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 公平锁与非公平锁
 */
@SuppressWarnings("all")
public class Reen4 {

    Lock lock = new ReentrantLock(true);
//    Lock lock = new ReentrantLock(false);
    void m(){
        for(int i =0;i<100;i++){
            lock.lock();
            System.out.println(Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }


    public static void main(String[] args) {
        Reen4 reen4 = new Reen4();
        new Thread(reen4::m).start();
        new Thread(reen4::m).start();
        new Thread(reen4::m).start();
    }

}
