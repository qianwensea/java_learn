package com.shi.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * jdk5.0 新增了foreach循环,用于遍历数组,集合
 *
 * @author 千文sea
 * @create 2020-04-02 15:59
 */
public class ForeachTest {
    @Test
    public void test1 (){
        Collection coll  = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add("Tom");
        coll.add(false);
        coll.add(new Person("Jack",21));

        //for(集合中元素的类型 局部变量 : 集合对象)
        for(Object obj : coll){
            System.out.println(obj);
        }
        //for(数组元素的类型 局部变量 : 数组对象)
        int arr[] = new int[]{123,344,55,13323,666};
        for(int i : arr){
            System.out.println(i);
        }
    }
    @Test
    public void test2(){
        String[] arr = new String[]{"MM","GG","DD"};
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = "HH";
//        }
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]); 输出"HH"
//        }
        for (String s : arr){
            s = "HH";
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]); //修改的是s的值,不改变arr[i]的值
        }

//                            String[] str = new String[5];
//                            for (String myStr : str) {
//                                myStr = "atguigu";
//                                System.out.println(myStr);
//                            }
//                            for (int i = 0; i < str.length; i++) {
//                                System.out.println(str[i]);
//                            }

    }
}
