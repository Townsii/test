package sync_test;

import java.util.concurrent.TimeUnit;

/**
 * 线程报错释放锁
 */
public class Sync4 {

    public synchronized void m() throws InterruptedException {
        int count = 0;
        while (true) {
            count++;
            System.out.println(Thread.currentThread().getName() + count);
            if (count == 5) {
                int temp = count / 0;
            }
            TimeUnit.SECONDS.sleep(1);
        }
    }

    public static void main(String[] args) {
        Sync4 sync4 = new Sync4();

//        Runnable r = new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    sync4.m();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        };
        Thread r = new Thread(){

            @Override
            public void run() {
                try {
                    sync4.m();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };


        for (int i = 0; i < 10; i++) {
            new Thread(r, "线程" + i).start();
        }


    }
}
