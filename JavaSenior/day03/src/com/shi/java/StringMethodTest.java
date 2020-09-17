package com.shi.java;

import org.junit.Test;

/**
 * @author 千文sea
 * @create 2020-03-30 16:57
 */
public class StringMethodTest {
    /*
        int length()：返回字符串的长度： return value.length
         char charAt(int index)： 返回某索引处的字符return value[index]
         boolean isEmpty()：判断是否是空字符串：return value.length == 0
         String toLowerCase()：使用默认语言环境，将 String 中的所有字符转换为小写
         String toUpperCase()：使用默认语言环境，将 String 中的所有字符转换为大写
         String trim()：返回字符串的副本，忽略前导空白和尾部空白
         boolean equals(Object obj)：比较字符串的内容是否相同
         boolean equalsIgnoreCase(String anotherString)：与equals方法类似，忽略大小写
         String concat(String str)：将指定字符串连接到此字符串的结尾。 等价于用“+”
         int compareTo(String anotherString)：比较两个字符串的大小
         String substring(int beginIndex)：返回一个新的字符串，它是此字符串的从beginIndex开始截取到最后的一个子字符串。
         String substring(int beginIndex, int endIndex) ：返回一个新字符串，它是此字符串从beginIndex开始截取到endIndex(不包含)的一个子字符串。

     */
    @Test
    public void test2(){
        String s1 = "helooworld";
        String s2 = "HelooWorld";
        System.out.println(s1.equals(s2));
        System.out.println(s1.equalsIgnoreCase(s2));

        String s3 = "abc";
        String s4 = s3.concat("def"); //相当于+
        System.out.println(s4);

        String s5 = "abc";
        String s6 = new String("abd");
        System.out.println(s5.compareTo(s6)); //涉及到字符串排序

        String s7 = "shijinhai";
        System.out.println(s7.substring(3));
        System.out.println(s7.substring(3,6)); //endIndex(不包含)  [s,e) 左闭右开


    }
    @Test
    public void test1(){
        String s1 = "helloworld";
        System.out.println(s1.length());
        System.out.print(s1.charAt(0));
        System.out.println(s1.charAt(9));
        System.out.println(s1.isEmpty());
        String s2 = s1.toUpperCase();
        System.out.println("s2: " + s2 + ",s1: " + s1); //s1是不可变的
        s2 = s2.toLowerCase();
        System.out.println("s2: " + s2 + ",s1: " + s1);

        String s3 = "  hell o wor ld ";
        String s4 = s3.trim(); //返回字符串的副本，忽略前导空白和尾部空白
        System.out.println("---" + s3 + "---");
        System.out.println("---" + s4 + "---");


    }
}
