package com.shi.java;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理举例
 *
 * @author 千文sea
 * @create 2020-04-09 15:58
 */
interface Human{
    String getBelief();
    void eat(String food);
}

class HumanUtil{
    public void method1(){
        System.out.println("===================通用方法一==================");
    }
    public void method2(){
        System.out.println("===================通用方法二==================");
    }
}
//被代理类
class SuperMan implements Human{

    @Override
    public String getBelief() {
        return "我是氪星人";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃" + food);
    }
}
/*
要想实现动态代理,需要解决的问题
    1.如何根据加载到内存中的被代理类,动态的创建一个代理类及其对象
    2.当通过代理类的对象调用方法时,如何动态的去调用被代理类中的同名方法
 */
class ProxyFactory{
    //调用此方法,返回一个代理类的对象.解决问题一
    public static Object getProxyInstance(Object obj){ //obj: 被代理类的对象
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.bind(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),handler);
    }
}
/*

 */
class MyInvocationHandler implements InvocationHandler{

    private Object obj; //需要使用被代理类的对象进行赋值
    public void bind(Object obj){
        this.obj = obj;
    }

    //当我们通过代理类的对象,调用方法a时,就会自动的调用如下的方法: invoke()
    //将被代理类要执行的方法a的功能就声明在invoke()中
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        HumanUtil util = new HumanUtil();
        util.method1();

        //method: 即为代理类对象调用的方法,此方法也就作为了被代理类对象要调用的方法
        //obj:即为被代理类的对象
        Object returnValue = method.invoke(obj, args);
        //上述方法的返回值,就作为当前类中invoke()方法返回值

        util.method2();

        return returnValue;
    }
}
public class ProxTest {
    public static void main(String[] args) {
        Human superman = new SuperMan();
        //proxyInstance: 就是代理类的对象
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superman);
        //当通过代理类对象调用方法时,会自动被代理类中同名的方法
        String belief = proxyInstance.getBelief();
        System.out.println(belief);
        proxyInstance.eat("四川火锅");
        System.out.println("**********************************");
        NikeClothFactory nikeClothFactory = new NikeClothFactory();
        ClothFactory proxyCloth = (ClothFactory) ProxyFactory.getProxyInstance(nikeClothFactory);
        proxyCloth.produceCloth();
    }
}
