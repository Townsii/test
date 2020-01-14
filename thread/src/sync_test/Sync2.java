package sync_test;

/**
 * 测试脏读
 */
public class Sync2 {

    private String name;
    private int balance;


    public Sync2() {
    }

    public Sync2(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }

    public synchronized void setBalance(String name, int balance) throws InterruptedException {
        if(this.name.equals(name)){
            this.balance = balance+this.balance;
            Thread.sleep(2000);
            this.balance = this.balance+66;
        }
    }
    //不加synchronized会产生脏读
    public synchronized void getBalance() throws InterruptedException {

            System.out.println(this.balance);
            Thread.sleep(5000);
            System.out.println(this.balance);
    }

    public static void main(String[] args) {
        Sync2 sync2 = new Sync2("town",100);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sync2.setBalance("town",55);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sync2.getBalance();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
