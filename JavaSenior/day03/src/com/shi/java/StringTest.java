package com.shi.java;

import org.junit.Test;

/**
 * String的使用
 *
 *
 * @author 千文sea
 * @create 2020-03-30 15:47
 */
public class StringTest {

    /*
        结论:
            常量与常量的拼接结果在常量池。且常量池中不会存在相同内容的常量。
            只要其中有一个是变量，结果就在堆中
            如果拼接的结果调用intern()方法，返回值就在常量池中
     */

    @Test
    public void test3(){
        String s1 = "javaEE";
        String s2 = "hadoop"; //使用final声明相当于常量
        String s3 = "javaEEhadoop";
        String s4 = "javaEE" +"hadoop";
        String s5 = s1 + "hadoop";
        String s6 = "javaEE" + s2;
        String s7 = s1 + s2;
        String s8 = s5.intern(); //返回值得到的s8使用的常量池中已经存在的"javaEEhadoop"
//        String s8 = "javaEE" + 1;
//        String s9 = "javaEE" + "1";
//        System.out.println(s8 == s9); //true

        System.out.println(s3 == s4); //true
        System.out.println(s3 == s5); //false
        System.out.println(s3 == s6); //false
        System.out.println(s3 == s7); //false
        System.out.println(s3 == s8); //true
        System.out.println(s5 == s6); //false
        System.out.println(s5 == s7); //false
    }


    /*
        比较String的创建方式
            通过字面量定义的方式
            通过new + 构造器的方式

        面试题: String s = new String("abc"); 方法创建对象,在内存中创建了几个对象?
                两个: 一个是堆空间中new出来的结构, 另一个是char[]对应的常量池中的数据: "abc"
     */
    @Test
    public void test2(){
        //通过字面量定义的方式: 此时s1和s2的数据声明在方法区中的字符串常量池中
        String s1 = "javaEE";
        String s2 = "javaEE";
        //通过new + 构造器的方式: 此时s3和s4保存的地址值,是数据在堆空间中开辟空间以后对应的地址值
        String s3 = new String("javaEE");
        String s4 = new String("javaEE");

        System.out.println(s1 == s2); //true
        System.out.println(s1 == s3); //false
        System.out.println(s1 == s4); //false
        System.out.println(s3 == s4); //false
    }


    /*
        String :字符串,使用一对""引起来表示
        1.String声明为 final,不可被继承
        2.String实现了java.io.Serializable: 表示字符串是支持序列化的
                     Comparable<String>:   表示字符串是可以比较的
                     CharSequence接口:    表示
        3.String内部定义了final char[] value用于存储字符串数据
        4.String: 代表不可变的字符序列. 简称:不可变性
            体现: 1.当对字符串重新赋值时,需要重新指定内存区域赋值,不能使用原有的value进行赋值
                 2.当对现有的字符串进行连接操作时,需要重新指定内存区域赋值,不能使用原有的value进行赋值
                 3.当调用String的replace()方法修改指定的字符或字符串时,需要重新指定内存区域赋值,不能使用原有的value进行赋值
        5.通过字面量的方式(区别与new的方式)给一个字符串赋值,此时字符串值声明在字符串常量池里.
        6.字符串常量池不会存储两个一样的字符串

     */
    @Test
    public void test1(){
        String s1 = "abc"; //字面量的定义方式
        String s2 = "abc"; //此时s1与s2的地址值一样
        System.out.println(s1 == s2); //true
        s1 = "hello";
        System.out.println(s1);
        System.out.println(s2);
        System.out.println("*******************");
        String s3 = "abc";
        s3 += "def";
        System.out.println(s3); //abcdef
        System.out.println("*******************");
        String s4 = "abc";
        String s5 = s4.replace('a', 'd');
        System.out.println(s4); //abc
        System.out.println(s5); //dbc

    }
}
