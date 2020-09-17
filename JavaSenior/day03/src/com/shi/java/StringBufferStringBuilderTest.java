package com.shi.java;

import org.junit.Test;

/**
 * StringBuffer和StringBuilder的使用
 *
 * @author 千文sea
 * @create 2020-03-31 14:48
 */
public class StringBufferStringBuilderTest {

    /*
        String与StringBuffer,StringBuilder的异同?

        String: 不可变的字符序列; 底层使用char[]存储.
        StringBuffer: 可变的字符序列; 线程安全的,效率较低,底层使用char[]存储.
        StringBuilder: 可变的字符序列; 线程不安全的,效率高,JDK5新增加的,底层使用char[]存储.

        源码分析:
        String str = new String();//new char[0]
        String str1 = new String("abc");//new char[]{'a','b','c'}

        StringBuffer sb1  = new StringBuffer(); //char[] valu = new char[16];底层创建了一个默认长度是16的数组
        System.out.println(sb1.length()); //0
        sb.append('a'); //value[0] = 'a';
        sb.append('b'); //value[1] = 'b';

        StringBuffer sb2  = new StringBuffer("abc"); //char[] valu = new char["abc".length() + 16];底层创建了一个默认长度是sb.length() + 16的数组
        //问题一: System.out.println(sb2.length()); //长度是多少?  3
        //问题二: 扩容问题: 如果要添加的数据底层数据装不下了,那就需要扩容底层的数组.
                    默认情况下,扩容为原来容量的2倍 + 2,同时将原有的数组中的元素复制到新的数组中

                    指导意义: 开发中建议大家使用: StringBuffer(int capacity)或StringBuilder(int capacity)来创建字符串
     */

    //StringBuffer常用方法
    /*
        增: append(xxx)
        删: delete(start,end)
        改: void setCharAt(int n ,char ch),replace(int start, int end, String str)
        查: char charAt(int n )
        插: insert(int offset, xxx)
        长度: length()
        遍历:
     */
    @Test
    public void test2(){
        /*
            StringBuffer append(xxx)：提供了很多的append()方法，用于进行字符串拼接
            StringBuffer delete(int start,int end)：删除指定位置的内容
            StringBuffer replace(int start, int end, String str)：把[start,end)位置替换为str
            StringBuffer insert(int offset, xxx)：在指定位置插入xxx
            StringBuffer reverse() ：把当前字符序列逆转

            public int indexOf(String str)
            public String substring(int start,int end) : 返回一个从start开始到end索引结束的左闭右开区间的子字符串
            public int length()
            public char charAt(int n )
            public void setCharAt(int n ,char ch)
         */
        StringBuffer s1 = new StringBuffer("abc");
        s1.append(1);
        s1.append("1");
        s1.append('d');
        System.out.println(s1);
        s1.delete(3,5);
        System.out.println(s1);
        s1.replace(0,5,"efgh");
        System.out.println(s1);
        s1.insert(0,"abcd");
        System.out.println(s1);
        s1.reverse();
        System.out.println(s1);
        String s2 = s1.substring(0, 3);
        System.out.println(s2);

    }

    @Test
    public void test1(){

        StringBuffer sb1 = new StringBuffer("abcd");
        sb1.setCharAt(0,'m');
        System.out.println(sb1); //mbcd


    }

    /*
        对比String,StringBuffer,StringBuilder的效率
        StringBuilder > StringBuffer > String
     */
    @Test
    public void test3(){
        //初始设置
        long startTime = 0L;
        long endTime = 0L;
        String text = "";
        StringBuffer buffer = new StringBuffer("");
        StringBuilder builder = new StringBuilder("");
        //开始对比
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            buffer.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer的执行时间：" + (endTime - startTime));
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            builder.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder的执行时间：" + (endTime - startTime));
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            text = text + i;
        }
        endTime = System.currentTimeMillis();
        System.out.println("String的执行时间：" + (endTime - startTime));
    }

    //面试题
    @Test
    public void test4(){
        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);
        System.out.println(sb.length());//
        System.out.println(sb);//
        StringBuffer sb1 = new StringBuffer(str);
        System.out.println(sb1);//
    }
}
