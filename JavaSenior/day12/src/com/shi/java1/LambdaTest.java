package com.shi.java1;

import org.junit.Test;

import java.util.Comparator;

/**
 * lambda表达式的使用举例
 *
 * @author 千文sea
 * @create 2020-04-09 16:58
 */
public class LambdaTest {
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
        Runnable r2 = () -> System.out.println("你好"); //Lambda表达式
        r2.run();
    }
    @Test
    public void test2(){
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };

        int compare1 = com1.compare(12, 21);
        System.out.println(compare1);

        System.out.println("************************************");
        //Lambda表达式写法
        Comparator<Integer> com2 = (o1,o2) -> Integer.compare(o1,o2);

        int compare2 = com2.compare(12, 21);
        System.out.println(compare2);

        System.out.println("*******************************");
        //方法引用
        Comparator<Integer> com3 = Integer::compare;
        int compare3 = com3.compare(22, 21);
        System.out.println(compare3);
    }
}
