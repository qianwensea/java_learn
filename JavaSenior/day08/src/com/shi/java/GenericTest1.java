package com.shi.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 如何自定义泛型结构: 泛型类,泛型接口;泛型方法
 *
 * 1. 关于自定义泛型类,泛型接口
 *
 *
 * @author 千文sea
 * @create 2020-04-05 16:27
 */
public class GenericTest1 {
    @Test
    public void test1(){
        //如果定义了泛型类,实例化时没有指明类的泛型,则认为此泛型类型为Object类型
        //要求: 如果大家定义了类是带泛型的,建议在实例化时要指明类的泛型
        Order order = new Order();
        order.setOrderId(2);
        order.setOrderT("tom");
        order.setOrderT(123);

        //建议: 实例化时指明类的泛型
        Order<String> order1 = new Order<>("AA",123,"Order");
        order1.setOrderT("Tom");
    }
    @Test
    public void test2(){
        SubOrder order = new SubOrder();
        //由于子类在继承带泛型的父类时,指明了泛型类型.则实例化子类对象时,不再需要指明泛型
        order.setOrderT(3333);
    }
    @Test
    public void test3(){
        //泛型不同的引用不能相互赋值
        ArrayList<String> list1 = null;
        ArrayList<Integer> list2 = null;
//        list1 = list2;
    }

    //测试泛型方法
    @Test
    public void test4(){
        Order<String> order = new Order<>();
        Integer[] arr = new Integer[]{1,2,3,4};
//        泛型方法在调用时,指明泛型的类型
        List<Integer> integers = order.copyFromArryList(arr);
        System.out.println(integers);
    }
}
