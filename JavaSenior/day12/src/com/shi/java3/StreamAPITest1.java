package com.shi.java3;

import com.shi.java2.Employee;
import com.shi.java2.EmployeeData;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 测试Stream的中间操作
 *
 * @author 千文sea
 * @create 2020-04-09 20:55
 */
public class StreamAPITest1 {
    //1-筛选与切片
    @Test
    public void test1(){
        List<Employee> list = EmployeeData.getEmployees();
//        filter(Predicate p) 接收 Lambda ， 从流中排除某些元素
        Stream<Employee> stream = list.stream();
        //练习: 查询员工表中薪资大于7000的员工信息
        stream.filter(e -> e.getSalary() > 7000).forEach(System.out :: println);
        System.out.println();

//        distinct() 筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
        list.add(new Employee(1010,"Jack",34,5000));
        list.add(new Employee(1010,"Jack",34,5000));
        list.add(new Employee(1010,"Jack",34,5000));
        Stream<Employee> stream1 = list.stream();
        stream1.distinct().forEach(System.out::println);
        System.out.println();

//        limit(long maxSize) 截断流，使其元素不超过给定数量
        list.stream().limit(4).forEach(System.out::println);
        System.out.println();

//        skip(long n) 跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一个空流。与 limit(n) 互补
        list.stream().skip(3).forEach(System.out :: println);
    }
    //映射
    @Test
    public void test2(){
//        map(Function f) 接收一个函数作为参数，该函数会被应用到每个元素上，并将其映成一个新的元素。
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        list.stream().map(str -> str.toUpperCase()).forEach(System.out::println);
        System.out.println();

        //练习: 获取员工姓名长度大于3的姓名
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<String> stringStream = employees.stream().map(e -> e.getName());
        stringStream.filter(str -> str.length() > 3).forEach(System.out::println);
        System.out.println();

        //练习2:
        Stream<Stream<Character>> streamStream = list.stream().map(StreamAPITest1::fromStringToStream);
        streamStream.forEach(s -> {
            s.forEach(System.out::println);
        });
        System.out.println();

//        flatMap(Function f) 接收一个函数作为参数，将流中的每个值都换成另 一个流，然后把所有流连接成一个流
        Stream<Character> characterStream = list.stream().flatMap(StreamAPITest1::fromStringToStream);
        characterStream.forEach(System.out::println);
    }
    //将字符串中多个字符构成的集合转换为对应的Stream的实例
    public static Stream<Character> fromStringToStream(String str){
        ArrayList<Character> list = new ArrayList<>();
        for (Character c : str.toCharArray()){
            list.add(c);
        }
        return list.stream();
    }
    //3-排序
    @Test
    public void test3(){
//        sorted() 产生一个新流，其中按自然顺序排序
        List<Integer> list = Arrays.asList(12, 34, 54, 22, 2, 0, 64, 49);
        list.stream().sorted().forEach(System.out::println);
        System.out.println("*********************************");

        List<Employee> employees = EmployeeData.getEmployees();
//        employees.stream().sorted().forEach(System.out::println); //在employee中要实现comparable接口

//        sorted(Comparator com) 产生一个新流，其中按比较器顺序排序
        employees.stream().sorted((e1,e2) -> {
            int compare = Integer.compare(e1.getAge(), e2.getAge());
            if (compare != 0){
                return compare;
            }
            return Double.compare(e1.getSalary(),e2.getSalary());
        }).forEach(System.out::println);
    }
}
