package src.threadpool_test;

import java.util.concurrent.*;

/**
 * callable调用call 有返回值 没有异常
 * runnable调用run 没有返回值 有异常
 */
public class CallableTest implements Callable {
    @Override
    public Object call() throws Exception {
        return null;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new Thread(String.valueOf(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 1000;
            }
        })).start();


        ExecutorService service = Executors.newFixedThreadPool(5);
        Future<Integer> f = service.submit(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 10;
        });
        System.out.println(f.get());
    }
}
