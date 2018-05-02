package java8.streamAPI;

import java8.lambda.java.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;


/**
 * 一、Stream的三个操作步骤
 * <p>
 * 1.创建Stream
 * <p>
 * 2.中间操作
 * <p>
 * 3.终止操作(终端操作)
 */
public class TestStreamAPI2 {

    // 公司员工信息集合
    private List<Employee> employees = Arrays.asList( // 数组转集合
            new Employee("张三", 18, 4444.44),
            new Employee("李四", 48, 8888.88),
            new Employee("王五", 26, 6666.11),
            new Employee("赵六", 32, 7777.22),
            new Employee("田七", 40, 9999.99),
            new Employee("田七", 40, 9999.99),
            new Employee("田七", 40, 9999.99)
    );

    // 中间操作

    /*
        映射：
        map —— 接收Lambda ，将元素转为其他形式或提取信息。接收一个函数作为参数，该函数会被应用到每个元素上，
        并将其映射成一个新的元素。
        flatMap —— 接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连成一个流
    */
    @Test
    public void test5() {
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee");

        list.stream()
                .map((s) -> s.toUpperCase())
                .forEach(System.out::println);

        System.out.println("----------------------------------");

        employees.stream()
                .map((e) -> e.getName())
                .forEach(System.out::println);

        System.out.println("----------------------------------");

        Stream<Stream<Character>> stream = list.stream()
                .map(TestStreamAPI2::filterCharacter);

        stream.forEach((sm) -> sm.forEach(System.out::println));

        System.out.println("----------------------------------");

        Stream<Character> stream2 = list.stream()
                .flatMap(TestStreamAPI2::filterCharacter);

        stream2.forEach(System.out::println);
    }


    private static Stream<Character> filterCharacter(String str) {
        List<Character> list = new ArrayList<>();

        for (Character ch : str.toCharArray()) {
            list.add(ch);
        }

        return list.stream();
    }

    /*
        筛选与切片
        filter —— 接收Lambda，从流中排除某些元素。
        limit —— 截断流，使其元素不超过给定数量。
        skip —— 跳过元素，返回一个扔掉了前n个元素的流。若流中元素不足n，则返回一个空流。与limit(n)互补
        distinct —— 筛选，通过流所生成元素的hashcode()和equals()去除重复元素
     */

    @Test
    public void test4() {
        employees.stream()
                .filter((e) -> e.getSalary() >= 5000)
                .skip(2)
                .distinct()
                .forEach(System.out::println);
    }

    @Test
    public void test3() {
        employees.stream()
                .filter((e) -> {
                    System.out.println("短路！"); // &&    ||
                    return e.getSalary() >= 5000;
                })
                .limit(2)
                .forEach(System.out::println);
    }

    // 内部迭代：迭代操作由 Stream API 完成
    @Test
    public void test1() {
        // 中间操作：不会执行任何操作
        Stream<Employee> s = employees.stream()
                .filter((e) -> {
                    System.out.println("Stream API 的中间操作");
                    return e.getAge() >= 35;
                });
        // 终止操作：一次性执行全部内容，即“惰性求值”
        s.forEach(System.out::println);
    }

    // 外部迭代
    @Test
    public void test2() {
        Iterator<Employee> it = employees.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
