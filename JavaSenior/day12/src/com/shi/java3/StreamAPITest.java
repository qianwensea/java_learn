package com.shi.java3;

import com.shi.java2.Employee;
import com.shi.java2.EmployeeData;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 1.Stream 和 Collection 集合的区别：Collection 是一种静态的内存数据
 * 结构，而 Stream 是有关计算的。前者是主要面向内存，存储在内存中，
 * 后者主要是面向 CPU，通过 CPU 实现计算。
 *
 * 2.
 * ①Stream 自己不会存储元素。
 * ②Stream 不会改变源对象。相反，他们会返回一个持有结果的新Stream。
 * ③Stream 操作是延迟执行的。这意味着他们会等到需要结果的时候才执行。
 *
 * 3.Stream的执行流程
 * 1- 创建 Stream: 一个数据源（如：集合、数组），获取一个流
 * 2- 中间操作: 一个中间操作链，对数据源的数据进行处理
 * 3- 终止操作(终端操作): 一旦执行终止操作，就执行中间操作链，并产生结果。之后，不会再被使用
 *
 * 测试Stream的实例化
 *
 * @author 千文sea
 * @create 2020-04-09 19:52
 */
public class StreamAPITest {
    //创建 Stream方式一：通过集合
    @Test
    public void test1(){
        List<Employee> employees = EmployeeData.getEmployees();
//          default Stream<E> stream() : 返回一个顺序流
        Stream<Employee> stream = employees.stream();
//          default Stream<E> parallelStream() : 返回一个并行流
        Stream<Employee> parallelStream = employees.parallelStream();

    }
    //创建 Stream方式二：通过数组
    @Test
    public void test2(){
        int[] arr = new int[5];
        //调用Arrays类的static <T> Stream<T> stream(T[] arra): 返回一个流
        IntStream stream = Arrays.stream(arr);

        Employee e1 = new Employee(1001,"Jack");
        Employee e2 = new Employee(1002,"Mark");
        Employee[] arr1 = new Employee[]{e1,e2};
        Stream<Employee> employeeStream = Arrays.stream(arr1);
    }
    //public static<T> Stream<T> of(T... values) : 返回一个流
    @Test
    public void test3(){
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
    }
    //创建 Stream方式四：创建无限流
    @Test
    public void test4(){
//        迭代
//        public static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f)
        //遍历前十个偶数
        Stream.iterate(0,t -> t + 2).limit(10).forEach(System.out::println);

//        生成
//        public static<T> Stream<T> generate(Supplier<T> s)
        Stream.generate(Math::random).limit(10).forEach(System.out :: println);
    }
}
