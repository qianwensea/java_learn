package com.shi.java;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;

/**
 * @author 千文sea
 * @create 2020-04-11 16:37
 */
public class java9Test {
    /*
        java8及之前创建只读集合的方式
     */
    @Test
    public void test1(){
        List<String> namesList = new ArrayList<>();
        namesList.add("Joe");
        namesList.add("Bob");
        namesList.add("Bill");
        //返回的nameList是一个只读的集合
        namesList = Collections.unmodifiableList(namesList);
//        namesList.add("Tom");
        System.out.println(namesList);
    }

    @Test
    public void test2(){
        List<String> list = Collections.unmodifiableList(Arrays.asList("a", "b", "c"));
        Set<String> set = Collections.unmodifiableSet(new HashSet<>(Arrays.asList("a",
                "b", "c")));
        // 如下操作不适用于jdk 8 及之前版本,适用于jdk 9
        Map<String, Integer> map = Collections.unmodifiableMap(new HashMap<>() {
            {
                put("a", 1);
                put("b", 2);
                put("c", 3);
            }
        });
        map.forEach((k, v) -> System.out.println(k + ":" + v));
    }
    @Test
    public void test3(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5); //这也是个只读集合
//        list.add(6);  UnsupportedOperationException
    }
     /*
    java9 新特性八:集合工厂方法：快速创建只读集合
     */
    @Test
    public void test4(){
        /*
        调用集合中静态方法of()，可以将不同数量的参数传输到此工厂方法中。此功能
        可用于Set和List，也可用于Map的类似形式。此时得到的集合，是不可变的：在
        创建后，继续添加元素到这些集合会导致 “UnsupportedOperationException” 。
        由于Java 8中接口方法的实现，可以直接在List，Set和Map的接口内定义这些方法，
        便于调用。
         */
        List<Integer> list = List.of(1, 2, 3, 4, 5);
//        list.add(6);
        System.out.println(list);

        Set<Integer> set = Set.of(1, 2, 3, 4, 5);
//        set.add(6);
        System.out.println(set);
    }
    /*
    java9 新特性9:InputStream 加强
     */
    @Test
    public void test5(){
        ClassLoader cl = this.getClass().getClassLoader();
        try (InputStream is = cl.getResourceAsStream("hello.txt");
             OutputStream os = new FileOutputStream("src\\hello1.txt")) {
            is.transferTo(os); // 把输入流中的所有数据直接自动地复制到输出流中
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
