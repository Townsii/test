package src.threadpool_test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * FutureTask阻塞线程 结束后返回
 */
public class FutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> task = new FutureTask<>(()->{
            TimeUnit.SECONDS.sleep(1);
            return 1000;
        });

        new Thread(task).start();
        System.out.println(task.get());

    }
}
