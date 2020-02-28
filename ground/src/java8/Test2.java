package src.java8;

import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@SuppressWarnings("all")
public class Test2 {

    @Test
    public void test1() {
        LambdaTest lambdaTest = () -> System.out.println("1111");
        lambdaTest.test();
    }

    @Test
    public void test2() {
        Consumer<String> consumer = System.out::println;
        consumer.accept("2222");
    }

    @Test
    public void test3() {
        new Thread(() -> System.out.println("111"), "线程一").start();
    }

    @Test
    public void test4() {
        happyTime(50, System.out::println);
    }

    @Test
    public void test5() {
        List<String> list = Arrays.asList("111", "abc", "222");

        List<String> a = filterString(list, s -> {
            return !s.contains("1");
        });
        System.out.println(a);
    }

    @Test
    public void test6() {
        LambdaTest lambdaTest = this::out;
        lambdaTest.test();
    }

    @Test
    public void test7() {
        Supplier<Test2> test2Supplier = Test2::new;
    }

    //测试Stream API 创建
    @Test
    public void test8() {
        //集合创建流
        List<String> list = Arrays.asList("1000", "2000", "3000", "4000");
        //串行流
        Stream<String> stream = list.stream();
        //并行流
        Stream<String> parallelStream = list.parallelStream();

        //数组创建流
        String[] str = new String[]{"111", "222"};
        Stream<String> strStream = Arrays.stream(str);
        int[] inte = new int[]{1, 2};
        IntStream intStream = Arrays.stream(inte);

        //stream创建流
        Stream<String> stringStream = Stream.of("111", "123");

        //无限流
        Stream.iterate(0, s -> s + 1).limit(10).forEach(System.out::println);
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }

    //测试Stream API 操作
    @Test
    public void test9() {
        List<Integer> list = Arrays.asList(1000, 2000, 3000, 4000, 5000, 6000, 7000, 7000, 7000);

        //过滤
        System.out.println("过滤**********************");
        list.stream().filter(s -> s < 2500).forEach(System.out::println);
        //截断
        System.out.println("截断**********************");
        list.stream().limit(3).forEach(System.out::println);
        //跳过
        System.out.println("跳过**********************");
        list.stream().skip(3).forEach(System.out::println);
        //去重
        System.out.println("去重**********************");
        list.stream().distinct().forEach(System.out::println);

        //映射
        System.out.println("映射**********************");
        list.stream().map(s -> s + 1).forEach(System.out::println);

        List<Integer> list1 = Arrays.asList(5,3,8,9,7,5);
        //排序
        System.out.println("排序**********************");
        list1.stream().sorted().forEach(System.out::println);
        System.out.println("定制正向排序**********************");
        list1.stream().sorted(Integer::compareTo).forEach(System.out::println);
        System.out.println("定制反向排序**********************");
        list1.stream().sorted((a,b) -> {
            if(a>b){
                return -1;
            }else if(a<b){
                return 1;
            }else {
                return 0;
            }
        }).forEach(System.out::println);
    }

    //flatMap映射
    @Test
    public void test10() {
        List<String> list = Arrays.asList("aa", "bb");


        //map映射
        System.out.println("map映射**********************");
        Stream<Stream<Character>> streamStream = list.stream().map(this::stringStream);
        streamStream.forEach(
                s -> s.forEach(System.out::println)
        );

        //flatMap映射
        System.out.println("flatMap映射**********************");
        Stream<Character> characterStream = list.stream().flatMap(this::stringStream);
        characterStream.forEach(System.out::println);

    }


    //终止操作
    @Test
    public void test11(){
        List<Integer> list = Arrays.asList(1000, 2000, 3000, 4000, 5000, 6000, 7000, 7000, 7000);

        //allMatch：是否全部符合
        System.out.println("allMatch**********************");
        boolean allMatch = list.stream().allMatch(s -> s > 3000);
        System.out.println(allMatch);

        //nonMatch：是否全部不符合
        System.out.println("nonMatch**********************");
        boolean noneMatch = list.stream().noneMatch(s -> s > 9000);
        System.out.println(noneMatch);

        //findFirst:返回第一个元素
        System.out.println("findFirst**********************");
        Optional<Integer> first = list.stream().findFirst();
        System.out.println(first);

        //findAny:返回任意元素
        System.out.println("findAny**********************");
        Optional<Integer> any = list.stream().findAny();
        Optional<Integer> any1 = list.parallelStream().findAny();
        System.out.println(any);
        System.out.println(any1);

        //count:返回元素个数
        System.out.println("count**********************");
        long count = list.stream().count();
        System.out.println(count);

        //max,min:返回最大最小
        System.out.println("max,min**********************");
        Optional<Integer> max = list.stream().max(Integer::compareTo);
        Optional<Integer> min = list.stream().min(Integer::compareTo);
        System.out.println(max+"####"+min);

        //forEach:遍历所有元素
        System.out.println("count**********************");
        list.stream().forEach(System.out::println);


        //归约
        System.out.println("归约**********************");
        Integer reduce = list.stream().reduce(0, Integer::sum);
        System.out.println(reduce);

        //收集
        System.out.println("收集**********************");
        List<Integer> collect = list.stream().collect(Collectors.toList());
        System.out.println(collect);

    }

    //Optional类
    @Test
    public void test12(){
        //非空对象创建Optional类
        Optional<Test2> test21 = Optional.of(new Test2());
        //创建空Optional类
        Optional<Object> empty = Optional.empty();
        //可空对象创建Optional类
        Optional<Test2> test22 = Optional.ofNullable(new Test2());

        System.out.println(test22);
    }

    //Optional去空指针
    @Test
    public void test13(){
        HumanTest humanTest = new HumanTest();


        //NullPointerException
//        String name = humanTest.getBoyTest().getName();

        Optional<HumanTest> humanTest1 = Optional.ofNullable(humanTest);
        HumanTest humanTest2 = humanTest1.orElse(new HumanTest("a", 22, new BoyTest("bbb")));

        BoyTest boyTest = humanTest2.getBoyTest();

        Optional<BoyTest> boyTest1 = Optional.ofNullable(boyTest);
        BoyTest boyTest2 = boyTest1.orElse(new BoyTest("aaa"));

        String name = boyTest2.getName();
        System.out.println(name);
    }


    private void happyTime(int money, Consumer<Integer> consumer) {
        consumer.accept(money);
    }

    private List<String> filterString(List<String> list, Predicate<String> predicate) {
        LinkedList<String> linkedList = new LinkedList<>();
        for (String s : list) {
            if (predicate.test(s)) {
                linkedList.add(s);
            }
        }
        return linkedList;
    }


    public void out() {
        System.out.println("666");
    }

    public Stream<Character> stringStream(String str) {
        ArrayList<Character> arrayList = new ArrayList<>();
        for (Character c : str.toCharArray()) {
            arrayList.add(c);
        }
        return arrayList.stream();
    }

}
