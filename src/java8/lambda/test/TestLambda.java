package java8.lambda.test;

import java8.lambda.java.Employee;
import java8.lambda.java.MyFun2;
import java8.lambda.java.MyFunction;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestLambda {
    private List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 4444.44),
            new Employee("李四", 48, 8888.88),
            new Employee("王五", 26, 6666.11),
            new Employee("赵六", 32, 7777.22),
            new Employee("田七", 40, 9999.99)
    );

    // 需求：按指定条件排序
    @Test
    public void test1() {
        Collections.sort(employees, (e1, e2) -> {
            if (e1.getAge() == e2.getAge()) {
                return e1.getName().compareTo(e2.getName());
            } else {
                return Integer.compare(e1.getAge(), e2.getAge());
            }
        });
    }

    @Test
    public void test2() {
        String str1 =
                strHandler("\t\t\ttonight i'm not happy,even a little sad.", s -> s.trim().toUpperCase()).substring(8);
        System.out.println(str1);
        String str2 =
                strHandler("i believe tomorrow is a good day.", String::toUpperCase).substring(10);
        System.out.println(str2);
    }

    // 需求：对字符串进行处理
    private String strHandler(String str, MyFunction mf) {
        return mf.getValue(str);
    }

    @Test
    public void test3() {
        Long l1 = longHandler(4L,5L,(x,y) -> x + y);
        System.out.println(l1);
        Long l2 = longHandler(6L,10L,(x,y) -> x * y);
        System.out.println(l2);
    }

    // 需求：对Long类型数据进行处理
    private Long longHandler(Long l1, Long l2, MyFun2<Long, Long> mf) {
        return (Long) mf.getValue(l1, l2);
    }
}
