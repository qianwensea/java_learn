package com.shi.java;

import org.junit.Test;

import java.util.*;

/**
 * 泛型的使用:
 * 1. jdk5.0新特性
 *
 * 2. 在集合中使用泛型:
 * 总结:
 *  ① 集合接口或集合类在jdk5.0时都修改为带泛型的结构
 *  ② 在实例化集合类时,可以指明具体的泛型类型
 *  ③ 指明以后,在集合类或接口中凡是定义类或接口时,内部结构(方法,属性,构造器等)使用到类的泛型位置,都指定为实例化的泛型类型
 *      如: add(E e) --> 实例化以后: add(Integer e)
 *  ④ 注意点: 泛型的类型必须是类,不能是基本数据类型.需要用到基本数据类型的位置,要转换为包装类在使用
 *  ⑤ 如果实例化时,没有指明泛型的类型,则默认为Object

 *3.如何自定义泛型结构: 泛型类,泛型接口;泛型方法
 *
 * @author 千文sea
 * @create 2020-04-05 15:46
 */
public class GenericTest {
    //在集合中使用泛型之前的情况:
    @Test
    public void test1(){
        ArrayList list = new ArrayList();
        //需求: 存放学生成绩
        list.add(44);
        list.add(66);
        list.add(75);
        list.add(87);
        //问题一: 类型不安全
        list.add("Tom");

        for (Object score : list){
            //问题二: 强转时,可能会出现ClassCastException
            int stuScore = (int)score;
            System.out.println(stuScore);
        }
    }
    //在集合中使用泛型的情况: 以ArrayList为例
    @Test
    public void test2(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        //需求: 存放学生成绩
        list.add(44);
        list.add(66);
        list.add(75);
        list.add(87);
        //编译时就会进行类型检查,保证数据的安全
//        list.add("Tom");
        //方式一:
//        for (Integer i : list){
//            //避免了强转操作
//            System.out.println(i);
//        }
        //方式二:
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    //在集合中使用泛型的情况: 以HashMap为例
    @Test
    public void test3(){
//        HashMap<String,Integer> map  =new HashMap<String,Integer>();
        //jdk7新特性: 类型推断
        HashMap<String,Integer> map  =new HashMap<>();
        map.put("Tom",22);
        map.put("Jack",62);
        map.put("Jerry",32);
        map.put("Mary",42);
        //泛型的嵌套
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Integer> entry = iterator.next();
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + "--" + value);
        }
    }
}
