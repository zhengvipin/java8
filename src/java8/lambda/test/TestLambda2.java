package java8.lambda.test;

import java8.lambda.java.MyFun;
import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;

/**
 * 一、Lambda表达式的基础语法：java8中引入了一个新的操作符"->"，该操作符被称为箭头操作符或 Lambda 操作符
 * 箭头操作符将Lambda表达式拆分成了两部分：
 * 左侧：Lambda 表达式的参数列表
 * 右侧：Lambda 表达式中所需执行的功能，即 Lambda体
 * <p>
 * 语法格式一：无参数，无返回值:
 * () -> System.out.println("Hello Lambda!");
 * <p>
 * 语法格式二：有一个参数，无返回值:
 * con = (x) -> System.out.println(x);
 * <p>
 * 语法格式三：若只有一个参数，小括号可以省略不写：
 * x -> System.out.println(x);
 * <p>
 * 语法格式四：有两个以上参数，并且 Lambda体中有多条语句：
 * Comparator<Integer> com = (x,y) -> {
 * System.out.println("函数式接口");
 * return Integer.compare(x,y);
 * };
 * <p>
 * 语法格式五：若 Lambda体中只有一条语句，return和大括号都可以省略不写：
 * Comparator<Integer> com = (x,y) -> Integer.compare(x,y);
 * <p>
 * 语法格式六：Lambda 表达式的数据类型可以省略不写，因为JVM编译器可以通过上下文推断出，数据类型，即"类型推断":
 * Comparator<Integer> com = (Integer x,Integer y) -> Integer.compare(x,y);
 * <p>
 * 上联：左右遇一括号省
 * 下联：左侧推断类型省
 * 横批：能省则省
 * <p>
 * 二：Lambda表达式需要"函数式接口"的支持
 * 函数式接口：接口中只有一个抽象方法的接口，称为函数式接口。
 * 可以使用注解@FunctionalInterface 修饰，可以检查是否是函数式接口
 */
public class TestLambda2 {

    @Test
    public void test1() {
        final int num = 0;//jdk 1.7之前，必须是final

        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World!" + num);
            }
        };
        r.run();
        System.out.println("-------------------------------");

        Runnable r1 = () -> System.out.println("Hello Lambda!");
        r1.run();
    }

    @Test
    public void test2() {
        Consumer<String> con = (x) -> System.out.println(x);
        con.accept("中华人民共和国万岁");
    }

    @Test
    public void test3() {
        Comparator<Integer> com = (x, y) -> {
            System.out.println("函数式接口");
            return Integer.compare(x, y);
        };
        System.out.println(com.compare(7, 8));
    }

    @Test
    public void test4() {
        Comparator<Integer> com = (Integer x, Integer y) -> Integer.compare(x, y);
        System.out.println(com.compare(7, 8));
    }

    @Test
    public void test5() {
        //String[] strings = {"aaa","bbb","ccc"};
        List<String> strings = new ArrayList<>();
        show(new HashMap<>());
    }

    private void show(Map<String, Integer> map) {
    }

    // 需求：对一个数进行运算
    @Test
    public void test6() {
        Integer num = operation(100,(x) -> (x * x));
        System.out.println(num);

        System.out.println(operation(200,(y) -> (y + 200)));
    }

    private Integer operation(Integer num, MyFun mf) {
        return mf.getValue(num);
    }
}
