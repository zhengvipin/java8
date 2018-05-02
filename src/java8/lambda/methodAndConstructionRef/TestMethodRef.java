package java8.lambda.methodAndConstructionRef;

import java8.lambda.java.Employee;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.*;

/**
 * 一、方法引用：若 Lambda体中的内容有方法已经实现了，我们可以使用"方法引用"
 * (可以理解为方法引用是 Lambda表达式的另外一种表现形式)
 *
 * 主要有三种语法格式：
 *
 * 对象::实例方法名
 *
 * 类::静态方法名
 *
 * 类::实例方法名
 *
 * 注意：
 * ①Lambda 体中调用方法的参数列表与返回值类型，要与函数式接口中抽象方法的函数列表和返回值类型一致
 * ②若 lambda体参数列表中的第一参数是 实例方法的调用者，而第二个参数是实例方法的参数时，可以使用ClassName::method
 *
 * 二、构造器引用：
 *
 * 格式：
 *
 * ClassName::new
 *
 * 注意：需要调用的构造器的参数列表要与函数式接口中抽象方法的参数列表保持一致！
 *
 * 三、数组引用
 *
 * Type::new
 */
public class TestMethodRef {
    // 对象::实例方法名
    @Test
    public void test1(){
        PrintStream ps1 = System.out;
        Consumer<String> con = (x) -> ps1.println(x);

        PrintStream ps = System.out;
        Consumer<String> con1 = ps::println;

        Consumer<String> con2 = System.out::println;
        con2.accept("sad");
    }

    @Test
    public void test2(){
        Employee emp = new Employee();
        Supplier<String> sup = () -> emp.getName();
        String str = sup.get();
        System.out.println(str);

        Supplier<Integer> sup2 = emp::getAge;
        Integer num = sup2.get();
        System.out.println(num);
    }

    // 类::静态方法名
    @Test
    public void test3(){
        Comparator<Integer> con = (x,y) -> Integer.compare(x,y);

        Comparator<Integer> con2 = Integer::compare;
    }

    // 类::实例方法名
    @Test
    public void test4(){
        BiPredicate<String,String> bp = (x,y) -> x.equals(y);

        BiPredicate<String,String> bp2 = String::equals;
    }

    // 构造器引用
    @Test
    public void test5(){
        Supplier<Employee> sup = () -> new Employee();

        // 构造器引用的方式
        Supplier<Employee> sup2 = Employee::new;
        Employee emp = sup.get();
        System.out.println(emp.getName());
    }

    @Test
    public void test6(){
        Function<Integer,Employee> fun = (x) -> new Employee(x);

        Function<Integer,Employee> fun2 = Employee::new;
        Employee employee = fun2.apply(101);
        System.out.println(employee);

        BiFunction<Integer,Double,Employee> bf = (x,y) -> new Employee(x,y);

        BiFunction<Integer,Double,Employee> bf2 = Employee::new;
        Employee employee1 = bf2.apply(18,5000d);
        System.out.println(employee1);
    }

    // 数组引用
    @Test
    public void test7(){
        Function<Integer,String[]> fun = (x) -> new String[x];
        String[] strings = fun.apply(10);
        System.out.println(strings.length);

        Function<Integer,String[]> fun2 = String[]::new;
        String[] strings2 = fun2.apply(20);
        System.out.println(strings2.length);
    }
}
