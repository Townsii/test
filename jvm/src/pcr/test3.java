package src.pcr;

public class test3 {
    public static void main(String[] args) {
        String a = new String("aa");
        String b = a.intern();
        String c = "aa";
        System.out.println(a==b);
        System.out.println(c==b);
    }
}
