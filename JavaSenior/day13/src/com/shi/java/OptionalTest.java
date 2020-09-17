package com.shi.java;

import org.junit.Test;

import java.util.Optional;

/**
 * @author 千文sea
 * @create 2020-04-10 17:02
 */
public class OptionalTest {
    @Test
    public void test1(){
        Optional<Object> op1 = Optional.empty();
        if (!op1.isPresent()){ //判断Optional封装的数据是否为空
            System.out.println("数据为空");
        }
//        System.out.println(op1.get());
        System.out.println(op1);
        System.out.println(op1.isPresent());
    }
    @Test
    public void test2(){
        //of(T t):封装数据t生成Optional对象. 要求t不能为null,否则报异常
        Optional<String> optionalS = Optional.of("hello");
        //get()通常与of()方法搭配使用.用于获取内部的封装数据value
        System.out.println(optionalS.get());

        String str = "Tom";
        //ofNullable(T t): 封装的数据t赋给Optional内部的value . 不要求t非空
        Optional<String> optionalS1 = Optional.ofNullable(str);
        //orElse(T t1): 如果Optional内部的value非空,则返回此value值.
        //如果value为空,则返回t1
        String orElse = optionalS1.orElse("Jack");
        System.out.println(orElse);

    }
}
