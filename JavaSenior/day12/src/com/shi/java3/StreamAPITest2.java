package com.shi.java3;

import com.shi.java2.Employee;
import com.shi.java2.EmployeeData;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream的终止操作
 *
 * @author 千文sea
 * @create 2020-04-09 21:34
 */
public class StreamAPITest2 {
    //1-匹配与查找
    @Test
    public void test1(){
        List<Employee> list = EmployeeData.getEmployees();
//        allMatch(Predicate p) 检查是否匹配所有元素
        //练习: 是否所有的员工的年龄都大于18
        boolean allMatch = list.stream().allMatch(e -> e.getAge() > 18);
        System.out.println(allMatch);

//        anyMatch(Predicate p) 检查是否至少匹配一个元素
        boolean anyMatch = list.stream().anyMatch(e -> e.getSalary() > 10000);
        System.out.println(anyMatch);

//        noneMatch(Predicate p) 检查是否没有匹配所有元素
        //练习: 是否存在姓"雷"的员工
        boolean noneMatch = list.stream().noneMatch(e -> e.getName().startsWith("雷"));
        System.out.println(noneMatch); //false表示存在

//        findFirst() 返回第一个元素
        Optional<Employee> employee = list.stream().findFirst();
        System.out.println(employee);

//        findAny() 返回当前流中的任意元素
        Optional<Employee> employee1 = list.parallelStream().findAny();
        System.out.println(employee1);
    }
    @Test
    public void test2(){
        List<Employee> employees = EmployeeData.getEmployees();
//        count() 返回流中元素总数
        long count = employees.stream().filter(e -> e.getSalary() > 5000).count();
        System.out.println(count);

//        max(Comparator c) 返回流中最大值
        //练习: 返回最高的工资
        Stream<Double> salaryStream = employees.stream().map(e -> e.getSalary());
        Optional<Double> max = salaryStream.max(Double::compare);
        System.out.println(max);

//        min(Comparator c) 返回流中最小值
        //练习: 返回最低的工资
        Optional<Employee> employee = employees.stream().min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(employee);

//        forEach(Consumer c) --内部迭代
        employees.stream().forEach(System.out::println);
//        内部迭代(使用 Collection 接口需要用户去做迭代，称为外部迭代。相反，Stream API 使用内部迭代——它帮你把迭代做了)
        //使用集合的遍历操作
        employees.forEach(System.out::println);
    }

    //2-归约
    @Test
    public void test3(){
        List<Employee> employees = EmployeeData.getEmployees();
//        reduce(T iden, BinaryOperator b) 可以将流中元素反复结合起来，得到一个值。返回 T
        //练习:计算1-10的自然数的和
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer sum = integers.stream().reduce(0, Integer::sum);
        System.out.println(sum);

//        reduce(BinaryOperator b) 可以将流中元素反复结合起来，得到一个值。返回 Optional<T>
        //练习:计算公司所有员工工资的总和
        Stream<Double> salary = employees.stream().map(e -> e.getSalary());
        Optional<Double> salarySum = salary.reduce(Double::sum);
        System.out.println(salarySum);
    }
    //3-收集
    @Test
    public void test4(){
        //collect(Collector c)
        //将流转换为其他形式。接收一个 Collector接口的实现，用于给Stream中元素做汇总的方法
        //练习: 查找工资大于6000的员工,结果返回一个list或set
        List<Employee> employees = EmployeeData.getEmployees();
        List<Employee> collect = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toList());
        collect.forEach(System.out::println);
        System.out.println("*****************************");
        Set<Employee> set = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toSet());
        set.forEach(System.out::println);
        System.out.println("*************************");

    }
}
