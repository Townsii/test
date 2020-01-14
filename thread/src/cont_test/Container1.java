package cont_test;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 特别注意 用while不能用if
 * if被唤醒后会继续运行剩余程序段
 * while会重新判断
 *
 * 用notifyall而不是notify是防止满了又叫醒一个生产者，或者空了又叫醒一个消费者
 *
 * @param <T>
 */
public class Container1<T> {

    private LinkedList<T> list = new LinkedList<>();
    private int MAX = 10;
    volatile private int count;

    public synchronized void put(T t) {

            while (list.size() == MAX) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
                list.add(t);
                count++;
                System.out.println(Thread.currentThread().getName() + "添加了" + t.toString());
                this.notifyAll();

        }


    public synchronized T get() {
        try {
            while (list.size() == 0) {
                this.notifyAll();
                this.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
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
        Container1<Integer> container1 = new Container1<>();
        final int[] flag = {0};
        for (int i = 0; i < 2; i++) {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        flag[0]++;
                        container1.put(flag[0]);
                    }

                }
            }, "生产者线程" + i).start();
        }


        for (int j = 0; j < 10; j++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        container1.get();
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
                    container1.getCount();
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

