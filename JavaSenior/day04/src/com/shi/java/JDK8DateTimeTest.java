package com.shi.java;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**
 * JDK8中日期时间API测试
 *
 *
 * @author 千文sea
 * @create 2020-03-31 19:49
 *
 */
public class JDK8DateTimeTest {
    @Test
    public void test1(){
//        Date date = new Date(2020,9,8);Fri Oct 08 00:00:00 CST 3920
        Date date = new Date(2020 - 1900,8,8); //Date有偏移量
        System.out.println(date);
    }

    /*
        LocalDate、LocalTime、LocalDateTime的使用
        说明:
            1.LocalDateTime的使用更多
     */
    @Test
    public void test2(){
        //now(): 获取当前的日期,时间,日期+时间
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        //of(): 设置指定的年月日时分秒,没有偏移量.
        LocalDateTime localDateTime1 = localDateTime.of(2020, 10, 6, 20, 33, 43);
        System.out.println(localDateTime1);

        //getXxx()
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfYear());
        System.out.println(localDateTime.getMonthValue());

        //withXxx(): 体现了不可变性
        LocalDate localDate1 = localDate.withDayOfMonth(29);
        System.out.println(localDate);
        System.out.println(localDate1);

        LocalDateTime localDateTime2 = localDateTime.withHour(12);
        System.out.println(localDateTime);
        System.out.println(localDateTime2);

        //plusXxx()
        LocalDateTime localDateTime3 = localDateTime.plusMonths(4);
        System.out.println(localDateTime);
        System.out.println(localDateTime3);
        //minusXxx()
        LocalDateTime localDateTime4 = localDateTime.minusDays(2);
        System.out.println(localDateTime);
        System.out.println(localDateTime4);
    }

    /*
        Instant 的使用
        类似 java.util.Date
     */
    @Test
    public void test3(){
        //now(): 获取本初子午线的对应的时间
        Instant instant = Instant.now();
        System.out.println(instant); //2020-03-31T12:11:27.889Z,本初子午线的时间
        //添加时间偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);

        //.toEpochMilli()计算毫秒数;返回1970-01-01 00:00:00到当前时间的毫秒数，即为时间戳
        System.out.println(instant.toEpochMilli());

        //ofEpochMilli(): 通过给定的毫秒数,获取Instant实例
        Instant instant1 = Instant.ofEpochMilli(1585656886078l);
        System.out.println(instant1);
    }

    /*
        DateTimeFormatter: 格式化日期,时间
        类似与simpleDateFormat
     */
    @Test
    public void test4(){
//    方式一:    预定义的标准格式:ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        //格式化: 日期 --> 字符串
        LocalDateTime localDateTime = LocalDateTime.now();
        String format = formatter.format(localDateTime);
        System.out.println(format);
        //解析: 字符串 --> 日期
        TemporalAccessor parse = formatter.parse("2020-03-31T20:21:36.679");
        System.out.println(parse);

//    方式二:    本地化相关的格式。如：ofLocalizedDateTime(FormatStyle.LONG)
//        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG); //2020年3月31日 下午08时27分32秒
        // 格式化
        String format1 = formatter1.format(LocalDateTime.now());
        System.out.println(format1);

//        DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL); //2020年3月31日 星期二
        DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM); //2020-3-31
        String format2 = formatter2.format(LocalDateTime.now());
        System.out.println(format2);

//   中点 方式三:    自定义的格式。如：ofPattern(“yyyy-MM-dd hh:mm:ss”)
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        //格式化
        String format3 = formatter3.format(LocalDateTime.now());
        System.out.println(format3);

        //解析
        TemporalAccessor parse1 = formatter3.parse("2020-03-31 08:37:16");
        System.out.println(parse1);
    }
}
