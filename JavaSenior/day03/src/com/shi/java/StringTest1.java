package com.shi.java;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * 涉及String与其他结构之间的转换
 *
 * @author 千文sea
 * @create 2020-03-30 17:49
 */
public class StringTest1 {

    /*
        String 与 byte[]之间的转换
        编码: String --> byte[] :  调用string的getBytes()
        解码: byte[] --> String:  调用string的构造器

        编码: 字符串 ---> 字节
        解码: 字节 ---> 字符串

        说明: 解码时,要求解码使用的字符集要和编码使用的字符集一致,否则会出现乱码
     */

    @Test
    public void test3() throws UnsupportedEncodingException {
        String s1 = "abc123中国";
        byte[] bytes = s1.getBytes(); //使用默认字符集,进行转换
        System.out.println(Arrays.toString(bytes));

        byte[] gbks = s1.getBytes("gbk"); //使用gbk字符集进行编码
        System.out.println(Arrays.toString(gbks));
        System.out.println("*************************************");

        String s2 = new String(bytes); //s使用默认字符集进行解码
        System.out.println(s2);

        String s3 = new String(gbks);
        System.out.println(s3); //乱码原因, 编码集与解码集不一致

        String s4 = new String(gbks, "gbk");
        System.out.println(s4);
    }


    /*
        String 与 char[]之间的转换
        String --> char[] :  调用string的totoCharArray()
        char[] --> String:  调用string的构造器
     */
    @Test
    public void test2(){
        String s1 = "abc123";
        char[] arr = s1.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println("*************************");
        char[] arr2 = new char[]{'1','2','a','b','3','c','.'};
        String s2 = new String(arr2);
        System.out.println(s2);

     }



    /*
        String与基本数据类型\包装类之间的转换
        String --> 基本数据类型,包装类: 调用包装类的静态方法: parsexxx(str)
        基本数据类型,包装类 ---> String : 调用String重载的valueOf(xxx)
     */
    @Test
    public void test1(){

        String s1 = "123";
        int num =  Integer.parseInt(s1);
        System.out.println(num);

        String s2 = String.valueOf(num);
        String s3 = num + "";
    }
}
