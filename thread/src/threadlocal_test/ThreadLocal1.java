package threadlocal_test;

import java.util.concurrent.TimeUnit;

/**
 * 线程内部变量，线程之间不可见
 */
public class ThreadLocal1 {

    private static ThreadLocal<String> local = new ThreadLocal<>();

    public static void main(String[] args) {
        new Thread(() -> {
            local.set("线程一");
            System.out.println(local.get());
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(local.get());
        }).start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            local.set("线程二");
        }).start();
    }

}
