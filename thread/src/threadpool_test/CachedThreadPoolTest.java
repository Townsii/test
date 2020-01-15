package src.threadpool_test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 根据需要创建线程 有空闲用空闲线程
 * 一段时间不用会自己销毁线程
 */
public class CachedThreadPoolTest {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        TimeUnit.SECONDS.sleep(2);
        for (int i = 0; i < 10; i++) {
            service.execute(() -> {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            });
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(service);
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }
}
