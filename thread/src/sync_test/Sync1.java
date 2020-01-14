package sync_test;

/**
 * 线程创建方法及synchronized
 */
public class Sync1{

    private int count = 0;

    private synchronized void m1() {
        count++;
        System.out.println(Thread.currentThread().getName()+"-"+count);
    }

    public static void main(String[] args) {
        Sync1 sync = new Sync1();
        for (int i = 0; i < 100; i++) {
//            new Thread(sync,"线程"+i).start();
//            new Thread(()->sync.m1(),"线程"+i).start();
            new Thread(sync::m1,"线程"+i).start();
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    sync.m1();
//                }
//            }).start();
        }


    }
}

