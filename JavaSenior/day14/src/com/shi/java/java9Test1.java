package com.shi.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author 千文sea
 * @create 2020-04-11 17:10
 */
public class java9Test1 {
    /*
    java9 新特性10 : 增强的 Stream API
     */
    @Test
    public void test1(){
        //takeWhile()的使用
        List<Integer> list = Arrays.asList(23, 33, 12, 43, 44, 65, 31);
        //takeWhile 返回从开头开始,按照指定规则尽量多的元素。
//        list.stream().takeWhile(x -> x < 60).forEach(System.out::println);
        //dropWhile 的行为与 takeWhile 相反，返回剩余的元素。
//        list.stream().dropWhile(x -> x <60).forEach(System.out::println);

    }
    @Test
    public void test2(){
        //ofNullable()的使用
        //Java 8 中 Stream 不能完全为null，否则会报空指针异常。而 Java 9 中的 ofNullable 方
        //法允许我们创建一个单元素 Stream，可以包含一个非空元素，也可以创建一个空Stream。

        //of()中的多个元素可以包含null值
        Stream<Integer> stream1 = Stream.of(1, 2, 3, null);
        stream1.forEach(System.out::println);
        //of()中不能只存储单个null值
//        Stream<Object> stream2 = Stream.of(null);
//        stream2.forEach(System.out::println);

        //ofNullable()
        Integer i = 10;
        i = null;
        //ofNullable() : 形参可以为单个为null的元素
        Stream<Integer> stream3 = Stream.ofNullable(i);
        System.out.println(stream3.count()); //0
    }
    @Test
    public void test3(){
        //iterate()重载的使用,可以让你提供一个 Predicate (判断条件)来指定什
        //么时候结束迭代。
        // 原来的控制终止方式：
        Stream.iterate(1, i -> i + 1).limit(10).forEach(System.out::println);
        // 现在的终止方式：
        Stream.iterate(1, i -> i < 100, i -> i + 1).forEach(System.out::println);
    }
    /*
    java9 新特性11:Optional获取Stream的方法
     */
    @Test
    public void test4(){
        //Optional类中stream()的使用
        List<String> list = new ArrayList<>();
        list.add("Tom");
        list.add("Jerry");
        list.add("Tim");
        Optional<List<String>> optional = Optional.ofNullable(list);
        Stream<List<String>> stream = optional.stream();
        stream.flatMap(x -> x.stream()).forEach(System.out::println);
    }
}
