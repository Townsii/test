package cont_test;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用ReentrantLock和newCondition
 * @param <T>
 */
public class Container2<T> {


    private LinkedList<T> list = new LinkedList<>();
    private int MAX = 10;
    volatile private int count;

    Lock lock = new ReentrantLock();
    Condition pro = lock.newCondition();
    Condition con = lock.newCondition();


    public  void put(T t) {
        lock.lock();
        while (list.size() == MAX) {
            try {
                pro.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            list.add(t);
            count++;
            System.out.println(Thread.currentThread().getName() + "添加了" + t.toString());
            con.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }


    public synchronized T get() {
        lock.lock();
        try {
            while (list.size() == 0) {
                pro.signalAll();
                con.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        T t = list.removeFirst();
        System.out.println(Thread.currentThread().getName() + "拿到了" + t.toString());
        return t;
    }

    public void getCount() {
        System.out.println("容器现在的个数是" + list.size());
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Container2<Integer> Container2 = new Container2<>();
        final int[] flag = {0};
        for (int i = 0; i < 2; i++) {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        flag[0]++;
                        Container2.put(flag[0]);
                    }

                }
            }, "生产者线程" + i).start();
        }


        for (int j = 0; j < 10; j++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        Container2.get();
                        try {
                            TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }, "消费者线程" + j).start();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    Container2.getCount();
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
