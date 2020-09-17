package com.shi.java;

/**
 * @author 千文sea
 * @create 2020-04-10 20:49
 */
public class MyInterfaceImpl implements MyInterface{
    @Override
    public void methodAbstract() {

    }

    @Override
    public void methodDefault() { //默认方法可以选择重写
        System.out.println("实现类重写了接口中的默认方法");
    }

    public static void main(String[] args) {
        //接口中的静态方法只能由自己调用
        MyInterface.methodStatic();

        MyInterfaceImpl mi = new MyInterfaceImpl();
        mi.methodDefault();
    }
}
