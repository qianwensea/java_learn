package com.shi.java;

/**
 * 静态代理举例
 * 特点: 代理类和被代理类在编译期间就确定了
 * @author 千文sea
 * @create 2020-04-09 15:50
 */
interface ClothFactory{
    void produceCloth();
}
//代理类
class ProxyClothFactory implements ClothFactory{

    private ClothFactory factory; //用被代理类实例化
    public ProxyClothFactory(ClothFactory factory){
        this.factory = factory;
    }
    @Override
    public void produceCloth() {
        System.out.println("代理工厂做一些准备工作");
        factory.produceCloth();
        System.out.println("代理工厂做一些后续的收尾工作");
    }
}
class NikeClothFactory implements ClothFactory{

    @Override
    public void produceCloth() {
        System.out.println("Nike工厂生产运动服");
    }
}
public class StaticProxyTest {
    public static void main(String[] args) {
        //创建被代理类对象
        ClothFactory nike =  new NikeClothFactory();
        //创建代理类对象
        ClothFactory proxy = new ProxyClothFactory(nike);
        proxy.produceCloth();
    }
}
