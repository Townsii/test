package sync_test;

import java.util.ArrayList;
import java.util.List;

/**
 * volatile保证可见性
 * synchronized保证原子性和可见性，但重量级
 */
public class Volatile2 {
    volatile int count = 0;

    synchronized void m(){
        for(int i = 0;i<10000;i++){
            count++;
        }
    }

    public static void main(String[] args) {
        Volatile2 volatile2 = new Volatile2();
        List<Thread> threads = new ArrayList<>();
        for(int i=0;i<10;i++){
            threads.add(new Thread(volatile2::m,"thread"+i));
        }
        for(Thread  t:threads){
            t.start();
        }
        //join方法阻塞线程直到计算完成
        for(Thread  t:threads){
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(volatile2.count);
    }
}
