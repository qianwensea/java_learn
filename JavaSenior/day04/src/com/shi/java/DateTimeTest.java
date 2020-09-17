package com.shi.java;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * jdk 8之前的日期时间的API测试
 * 1.System类中的currentTimeMills()
 * 2.java.util.Date和子类java.sql.Date
 * 3.SimpleDateFormat
 * 4.Calendar
 * @author 千文sea
 * @create 2020-03-31 18:56
 */
public class DateTimeTest {
    /*
        SimpleDateFormat的使用: SimpleDateFormat对日期Date类的格式化和解析

        1.两个操作:
            1.1 格式化: 日期 --> 字符串
            1.2 解析: 字符串 --> 日期

        2.SimpleDateFormat的实例化
     */
    @Test
    public void testSimpleDateFormat() throws ParseException {
        //实例化SimpleDateFormat: 使用默认的构造器
        SimpleDateFormat sdf = new SimpleDateFormat();

        //格式化: 日期 --> 字符串
        Date date = new Date();
        System.out.println(date);
        String format = sdf.format(date);
        System.out.println(format);

        //解析: 字符串 --> 日期
        String str = "20-3-31 下午7:04";
        Date parse = sdf.parse(str);
        System.out.println(parse);

        //*****************按照指定的方式格式化和解析********************
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        //格式化
        String format1 = sdf1.format(date);
        System.out.println(format1); //2020-03-31 07:10:07
        //解析: 要求字符串必须是符合SimpleDateFormat构造器的格式,否则就会抛异常
        Date parse1 = sdf1.parse("2020-03-31 07:11:34");
        System.out.println(parse1);
    }

    /*
        练习一: 字符串"2020-09-08"转换为java.sql.Date

     */
    @Test
    public void exer() throws ParseException {
        String s = "2020-09-08";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = sdf.parse(s);
        System.out.println(parse);
        java.sql.Date birth = new java.sql.Date(parse.getTime());
        System.out.println(birth);
    }

    /*
         java.util.Calendar(日历)类
         Calendar是一个抽象基类，主用用于完成日期字段之间相互操作的功能。
             获取Calendar实例的方法
             使用Calendar.getInstance()方法
             调用它的子类GregorianCalendar的构造器。
             一个Calendar的实例是系统时间的抽象表示，通过get(int field)方法来取得想
            要的时间信息。比如YEAR、MONTH、DAY_OF_WEEK、HOUR_OF_DAY 、
            MINUTE、SECOND
             public void set(int field,int value)
             public void add(int field,int amount)
             public final Date getTime()
             public final void setTime(Date date)
             注意:
             获取月份时：一月是0，二月是1，以此类推，12月是11
             获取星期时：周日是1，周二是2 ， 。。。。周六是7
     */
    @Test
    public void testCalender(){
        //实例化
        //方式一:创建子类对象: GregorianCalendar的对象
        //方式二: 调用静态方法: Calendar.getInstance()
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getClass());

        //常用方法
        //get()
        int days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));
        //set()
        calendar.set(Calendar.DAY_OF_MONTH,22);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //add()
        calendar.add(Calendar.DAY_OF_MONTH,3);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //getTime()  日历类 --> Date
        Date time = calendar.getTime();
        System.out.println(time);

        //setTime() Date --> 日历类
        Date date1 = new Date();
        calendar.setTime(date1);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
    }
}
