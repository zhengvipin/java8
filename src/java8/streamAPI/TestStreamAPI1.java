package java8.streamAPI;

import java8.lambda.java.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
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
public class TestStreamAPI1 {

    // 创建Stream
    @Test
    public void test1() {
        // 1.可以通过Collection 系列集合提供的stream()或ParallelStream()
        List<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();

        // 2.通过Arrays 中的静态方法 stream() 获取数组流
        Employee[] employees = new Employee[10];
        Stream<Employee> stream2 = Arrays.stream(employees);

        // 3.通过 Stream类中的静态方法of()
        Stream<String> stream3 = Stream.of("aa", "bb", "cc");

        // 4.创建无限流
        // 迭代
        Stream<Integer> stream4 = Stream.iterate(0, (x) -> x + 2);
        stream4.limit(10).forEach(System.out::println);

        // 生成
        Stream.generate(() -> Math.random())
                .limit(5).forEach(System.out::println);
    }
}
