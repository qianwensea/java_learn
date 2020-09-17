package com.shi.java;

import org.junit.Test;

import java.util.Date;

/**
 * JDK 8之前日期和时间的API测试
 *
 * @author 千文sea
 * @create 2020-03-31 15:54
 */
public class DateTimeTest {


    @Test
    public void test2(){
        /*
             2. java.util.Date类
                        ---java.sql.Date
            表示特定的瞬间，精确到毫秒
             构造器：
             Date()：使用无参构造器创建的对象可以获取本地当前时间。
             Date(long date)
             常用方法
             getTime():返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象
            表示的毫秒数。
             toString():把此 Date 对象转换为以下形式的 String： dow mon dd
            hh:mm:ss zzz yyyy 其中： dow 是一周中的某一天 (Sun, Mon, Tue,
            Wed, Thu, Fri, Sat)，zzz是时间标准。
             其它很多方法都过时了。
         */
        Date date = new Date(); //对应当前世界的Date对象
        System.out.println(date.toString());
        System.out.println(date.getTime());

        Date date1 = new Date(1585641736891l); //创建指定毫秒数的date对象
        System.out.println(date1);

        //如何将java.util.date对象转换为 java.sql.date的对象
        //情况一
        Date date4 = new java.sql.Date(1585641736891l);

        java.sql.Date date5 = (java.sql.Date) date4;
        //情况二:
        Date date6 = new Date();
        java.sql.Date date7 = new java.sql.Date(date6.getTime());
    }

    @Test
    public void test1(){
        /*
            1. java.lang.System类
            System类提供的public static long currentTimeMillis()用来返回当前时
            间与1970年1月1日0时0分0秒之间以毫秒为单位的时间差。
             此方法适于计算时间差。
         */
        long time = System.currentTimeMillis(); //称为时间戳
        System.out.println(time);

    }
}
