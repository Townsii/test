package concurrent_test;

import java.util.concurrent.*;

public class QueueTest {

    /**
     * poll 取值并弹出 先进先出 为空继续拿
     * peek 取值但不拿出
     */
    //单向队列
    ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
    //双向队列
    ConcurrentLinkedDeque concurrentLinkedDeque = new ConcurrentLinkedDeque();

    /**
     * add 无论什么清空都会添加，会抛异常
     * offer 达到边界返回false，不添加但一直尝试添加
     * <p>
     * put 达到边界阻塞线程
     * take 为空阻塞线程 先进先出
     */
    //无界阻塞式队列
    LinkedBlockingDeque linkedBlockingDeque = new LinkedBlockingDeque();
    //有界阻塞式队列
    ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(10);

    //延时队列，过一段时间才能拿,一般用于任务执行队列
    DelayQueue<Delayed> delayQueue = new DelayQueue<Delayed>();

    //转化队列，用于生产者与消费者模式
    //使用ltq.transfer("消息")时会直接把消息发送给消费者，而不是放到容器中
    //消费者阻塞时调用transfer会引起线程阻塞
    TransferQueue ltq = new LinkedTransferQueue();

    //sq容量为0，不能add只能put
    //put后等待消费者消费
    //sq是完全的Transfer
    SynchronousQueue<String> sq = new SynchronousQueue<>();


    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue abqTest = new ArrayBlockingQueue(10);
        for (int i = 0; i < 5; i++) {
            abqTest.put(i);
            System.out.println(abqTest);
            TimeUnit.SECONDS.sleep(1);
        }
        for (int i = 0; i < 100; i++) {
            abqTest.take();
            System.out.println(abqTest);
            TimeUnit.SECONDS.sleep(1);
        }
    }

}
