package sync_test;

/**
 * 测试死锁
 */
public class Sync3 {

    synchronized void m1() throws InterruptedException {
        m2();
        Thread.sleep(2000);
    }

    synchronized void m2() throws InterruptedException {
        m1();
        Thread.sleep(2000);
    }

    public static void main(String[] args) {
        Sync3 sync3 = new Sync3();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sync3.m1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sync3.m2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
