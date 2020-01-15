package src.threadpool_test;

import java.util.concurrent.Executor;

public class ExecutorTest implements Executor {
    @Override
    public void execute(Runnable command) {
        command.run();
    }

}
