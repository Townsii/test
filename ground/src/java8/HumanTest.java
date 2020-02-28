package src.java8;

public class HumanTest {

    private String name;
    private int age;
    private BoyTest boyTest;

    public HumanTest() {
    }

    public HumanTest(String name, int age, BoyTest boyTest) {
        this.name = name;
        this.age = age;
        this.boyTest = boyTest;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public BoyTest getBoyTest() {
        return boyTest;
    }

    public void setBoyTest(BoyTest boyTest) {
        this.boyTest = boyTest;
    }
}
