package src.pcr;

public class test4 {
    public static void main(String[] args) {
        String a = "aaa";
        String b = "bbb";
        String ab = "aaabbb";
        String aabb = a+b;
        System.out.println(ab == aabb);
        System.out.println(ab == aabb.intern());
    }
}
