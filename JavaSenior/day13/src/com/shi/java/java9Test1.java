package com.shi.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author 千文sea
 * @create 2020-04-11 16:14
 */
public class java9Test1 {
    /*
    java9 新特性八:集合工厂方法：快速创建只读集合
     */
    @Test
    public void test1(){
        List<String> namesList = new ArrayList<>();
        namesList.add("Joe");
        namesList.add("Bob");
        namesList.add("Bill");
        //返回的nameList是一个只读的集合
        namesList = Collections.unmodifiableList(namesList);
//        namesList.add("Tom");
        System.out.println(namesList);
    }
}
