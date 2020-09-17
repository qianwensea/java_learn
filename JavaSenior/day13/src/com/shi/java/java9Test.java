package com.shi.java;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;

/**
 * @author 千文sea
 * @create 2020-04-10 20:53
 */
public class java9Test {
    /*
    Java9的新特性: 钻石操作符的升级
     */
    @Test
    public void test1(){
        //钻石操作符与匿名内部类在java 8中不能共存,在Java 9中可以
        Comparator<Object> com = new Comparator<>() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        };
    }
    /*
    java9 特性6: try操作符的升级
     */
    public static void main(String[] args) {
        //java 8之前的资源关闭操作
//        InputStreamReader reader = null;
//        try {
//            reader = new InputStreamReader(System.in);
//            char[] cbuf = new char[20];
//            int len;
//            if ((len = reader.read(cbuf)) != -1){
//                String str = new String(cbuf,0,len);
//                System.out.println(str);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (reader != null) {
//                try {
//                    reader.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
        //Java 8中资源关闭的操作,可以实现资源的自动关闭，但是要求执行后必须关闭的所有资源必
        //须在try子句中初始化，否则编译不通过。
//        try(InputStreamReader reader = new InputStreamReader(System.in)){
//            char[] cbuf = new char[20];
//            int len;
//            if ((len = reader.read(cbuf)) != -1){
//                String str = new String(cbuf,0,len);
//                System.out.println(str);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        //java 9中资源关闭的操作:可以在try子句中使用已经初始
        //化过的资源，此时的资源是final的：
        InputStreamReader reader = new InputStreamReader(System.in);
        try(reader) {
            char[] cbuf = new char[20];
            int len;
            if ((len = reader.read(cbuf)) != -1){
                String str = new String(cbuf,0,len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
