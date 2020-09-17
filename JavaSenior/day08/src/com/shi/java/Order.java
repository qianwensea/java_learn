package com.shi.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 千文sea
 * @create 2020-04-05 16:23
 */
public class Order <T>{
    String orderName;
    int orderId;
    //类的内部结构就可以是能使用类的泛型
    T orderT;
    public Order(){
//        T[] arr = new T[10]; 编译不通过
        T[] arr = (T[]) new Object[10];
    }

    public Order(String orderName,int orderId,T orderT){
        this.orderName = orderName;
        this.orderId = orderId;
        this.orderT = orderT;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    //如下的三个方法不是泛型方法
    public T getOrderT() {
        return orderT;
    }

    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }

    //静态方法中不能使用类的泛型
//    public static void show(){
//        System.out.println(orderT);
//    }

    //泛型方法: 在方法中出现了泛型的结构,泛型参数与类的泛型参数没有任何关系
    //换句话说: 泛型方法所属的类是不是泛型类都没有关系
    //泛型方法,可以声明为静态的.原因: 泛型参数是在调用方法时确定的,并非在实例化类时确定
    public <E> List<E> copyFromArryList(E[] arr){
        ArrayList<E> list = new ArrayList<>();
        for (E e : arr){
            list.add(e);
        }
        return list;
    }
}
