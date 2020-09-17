package com.shi.java;

/**
 * @author 千文sea
 * @create 2020-04-10 20:45
 */
public interface MyInterface {
    void methodAbstract();
    static void methodStatic(){
        System.out.println("我是接口中的静态方法");
    }
    default void methodDefault(){
        System.out.println("我是接口中的默认方法");
    }
    //jdk9中允许接口中定义私有方法
    private void methodPrivate(){ //在jdk8中不支持
        System.out.println("我是接口中的私有方法");
    }
}
