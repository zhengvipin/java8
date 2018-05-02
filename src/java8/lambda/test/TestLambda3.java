package java8.lambda.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

/**
 * Java8 内置的四大核心函数式接口
 *
 * Consumer<T>：消费性接口
 *              void accept(T t)
 * Supplier<T>：供给型接口
 *              T get();
 * Function<T, R>：函数型接口
 *              R apply(T t);
 * Predicate<T>：断言型接口
 *              boolean test(T t);
 */
public class TestLambda3 {
    // Consumer<T>：消费性接口
    @Test
    public void test1() {
        happy(1000d, (m) -> System.out.println("买了个新手机，消费了" + m + "元"));
        happy(300d, (m) -> System.out.println("去KTV，花费了" + m + "元"));
    }

    private void happy(double money, Consumer<Double> con) {
        con.accept(money);
    }

    // Supplier<T>：供给型接口
    @Test
    public void test2() {
        List<Integer> numList = getNumList(8, () -> (int) (Math.random() * 100));
        numList.forEach(System.out::println);
    }

    // 产生指定个数的整数，并放入集合中
    private List<Integer> getNumList(Integer count, Supplier<Integer> sup) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(sup.get());
        }
        return list;
    }

    // Function<T, R>：函数型接口
    @Test
    public void test3() {
        String str1 = strHandler("中华人民共和国万岁", (s) -> s.substring(2, 7));
        System.out.println(str1);
        System.out.println("--------------------------------------------");
        String str2 = strHandler("\t\t\t我爱你  ", String::trim);
        System.out.println(str2);
    }

    // 需求：用于处理字符串
    private String strHandler(String str, Function<String, String> fun) {
        return fun.apply(str);
    }

    // BiFunction<T,U,R>
    // R r = apply(T t,U u)
    @Test
    public void test() {
        Long num1 = longHandler(4L, 6L, (x, y) -> x + y);
        System.out.println(num1);
        Long num2 = longHandler(10L, 5L, (x, y) -> x * y);
        System.out.println(num2);
    }

    // 需求：用于处理Long类型数据
    private Long longHandler(Long l1, Long l2, BiFunction<Long, Long, Long> biFun) {
        return biFun.apply(l1, l2);
    }

    // Predicate<T>：断言型接口
    @Test
    public void test4() {
        List<String> stringList = Arrays.asList("Hello", "www", "Lambda", "ok", "scott");
        List<String> newList = filterStr(stringList, (s) -> s.length() > 3);
        newList.forEach(System.out::println);
    }

    // 需求：将满足条件的字符串添加到集合中
    private List<String> filterStr(List<String> strList, Predicate<String> pre) {
        List<String> list = new ArrayList<>();
        for (String s : strList) {
            if (pre.test(s)) {
                list.add(s);
            }
        }
        return list;
    }
}
