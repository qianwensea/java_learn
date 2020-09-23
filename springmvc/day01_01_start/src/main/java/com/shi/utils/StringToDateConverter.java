package com.shi.utils;


import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 千文sea
 * @create 2020-09-23 15:41
 *
 * 将字符串转换为日期
 */
public class StringToDateConverter implements Converter<String,Date> {

    /**
     *
     * @param source  传入的字符串
     * @return
     */
    @Override
    public Date convert(String source) {
        if (source == null){
            throw new RuntimeException("请传入数据");
        }
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        //把字符串转换为日期
        try {
           return df.parse(source);
        } catch (Exception e) {
            throw new RuntimeException("数据类型转换出错");
        }
    }
}
