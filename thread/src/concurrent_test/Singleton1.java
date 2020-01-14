package concurrent_test;

/**
 * 内部类实现单例模式
 */
public class Singleton1 {

    private Singleton1(){
        System.out.println("singleton");
    }

    private static class inner{
        private static Singleton1 s = new Singleton1();
    }

    private static Singleton1 getSingle(){
        return inner.s;
    }



}
