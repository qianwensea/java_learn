package com.shi.java;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author 千文sea
 * @create 2020-04-11 17:34
 */
public class java10Test {
    /*
    java10 新特性
     */
    @Test
    public void test1(){
        //1.声明变量时,根据所附的值,推断变量的类型
        var num = 10;
        var list = new ArrayList<String>();
        list.add("Tom");

        //2.遍历操作
        for (var s : list){
            System.out.println(s);
            System.out.println(s.getClass());
        }
        for (var i = 0;i < 10;i++){
            System.out.println(i);
        }
    }
    @Test
    public void test2(){
        //1.局部变量不赋值是不能推断的
//        var num;
        var s = "hello";
        System.out.println(s.getClass());

        //2.lambda表达式中的函数式接口不能使用var
//        var sup1 = () -> Math.random();
        Supplier<Double> sup = () -> Math.random();

        //3.方法引用中
        Consumer<String> com = System.out::println;
//        var com1 = System.out::println;

        //4.数组的静态初始化
        int[] arr = new int[]{1,2,3,4};
        var arr1 = new int[]{1,2,3,4};
        //如下的情况不可以
//        var arr2 = {1,2,3,4};
    }
    @Test
    public void test4() {
//        情况1：没有初始化的局部变量声明
//        var s = null;


//         情况6：catch块
//        try {
//
//        }catch (var e){
//
//        }
//    }
        //         情况2：方法的返回类型
//    public var get(){
//        return 0;
//    }
        //         情况3：方法的参数类型
//    public void get(var i){
//
//    }
        //         情况4：构造器的参数类型
//    public java10Test(var i){
//
//    }
//         情况5：属性
//    var name;
    }
    @Test
    public void test5(){
        try {
            var url = new URL("http://www.atguigu.com");
            var connection = url.openConnection();
            var reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*
    java10 新特性2: 集合新增创建不可变集合的方法
     */
    @Test
    public void test6(){
        //示例1：
        var list1 = List.of("Java", "Python", "C");
        var copy1 = List.copyOf(list1);
        System.out.println(list1 == copy1); // true
        //示例2：
        var list2 = new ArrayList<String>();
        var copy2 = List.copyOf(list2);
        System.out.println(list2 == copy2); // false
        //示例1和2代码基本一致，为什么一个为true,一个为false?
        //结论: copyOf 方 法 会 先 判 断 来 源 集 合 是 不 是AbstractImmutableList 类型的，如果是，就直接返回，
        // 如果不是，则调用 of 创建一个新的集合。
    }
}
