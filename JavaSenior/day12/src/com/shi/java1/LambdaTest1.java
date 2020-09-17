package com.shi.java1;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * Lambda表达式的使用
 * 1.举例: (o1,o2) -> Integer.compare(o1,o2);
 * 2.格式:
 *      -> :Lambda操作符或箭头操作符
 *      ->的左边: Lambda的形参列表(其实就是接口中的抽象方法的形参列表)
 *      ->的右边: Lambda体(其实就是重写的抽象方法的方法体)
 *
 * 3.Lambda表达式的具体使用
 *      总结:
 *         ->左边: lambda形参列表的参数类型可以省略(类型推断);如果lambda形参列表只有一个参数,其一对()也可以省略
 *         ->右边: lambda体应该使用一对大括号{}包裹; 如果lambda体只有一条执行语句(可能是return语句),可以省略这一对{}和return关键字
 * 4.Lambda表达式的本质: 作为接口的具体实现类的实例
 * 5.只包含一个抽象方法的接口，称为函数式接口。(我们可以在一个接口上使用 @FunctionalInterface 注解，这样做可以检
 * 查它是否是一个函数式接口。)
 * 6.所以以前用匿名实现类表示的现在都可以用Lambda表达式来写。
 *
 * @author 千文sea
 * @create 2020-04-09 17:09
 */
public class LambdaTest1 {
    //语法格式一：无参，无返回值
    @Test
    public void test1(){
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        };
        r1.run();
        System.out.println("*******************");
        Runnable r2 = () -> {
            System.out.println("你好");
        }; //Lambda表达式
        r2.run();
    }
    //语法格式二：Lambda 需要一个参数，但是没有返回值。
    @Test
    public void test2(){
        Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con.accept("hello");

        System.out.println("****************");
        Consumer<String> con1 = (String s) -> {
            System.out.println(s);
        };
        con1.accept("world");
    }
    //语法格式三：数据类型可以省略，因为可由编译器推断得出，称为“类型推断”
    @Test
    public void test3(){
        Consumer<String> con1 = (String s) -> {
            System.out.println(s);
        };
        con1.accept("world");

        System.out.println("****************************");
        Consumer<String> con2 = (s) -> { //类型推断
            System.out.println(s);
        };
        con2.accept("world");
    }
    //语法格式四：Lambda 若只需要一个参数时，参数的小括号可以省略
    @Test
    public void test4(){
        Consumer<String> con1 = (s) -> {
            System.out.println(s);
        };
        con1.accept("world");
        System.out.println("**************************");

        Consumer<String> con2 = s -> {
            System.out.println(s);
        };
        con2.accept("world");
    }
    //语法格式五：Lambda 需要两个或以上的参数，多条执行语句，并且可以有返回值
    @Test
    public void test5(){
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1);
                System.out.println(o2);
                return Integer.compare(o1,o2);
            }
        };
        System.out.println(com.compare(22, 21));
        System.out.println("***************************");

        Comparator<Integer> com1 = (o1,o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return Integer.compare(o1,o2);
        };
        System.out.println(com1.compare(12, 13));
    }
    //语法格式六：当 Lambda 体只有一条语句时，return 与大括号若有，都可以省略
    @Test
    public void test6(){
        Comparator<Integer> com1 = (o1,o2) -> {
            return Integer.compare(o1,o2);
        };
        System.out.println(com1.compare(12, 13));

        System.out.println("**********************");
        Comparator<Integer> com2 = (o1,o2) -> Integer.compare(o1,o2);
        System.out.println(com2.compare(12, 13));
    }
}
