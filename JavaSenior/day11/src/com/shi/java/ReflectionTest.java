package com.shi.java;

import org.junit.Test;

import java.lang.annotation.ElementType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 反射机制:
 *
 * @author 千文sea
 * @create 2020-04-08 15:37
 */
public class ReflectionTest {
    //反射之前对于Person类的操作
    @Test
    public void test1(){
        //1.创建Person类的对象
        Person p1 = new Person("Tom",22);

        //2.通过对象调用内部属性和方法
        p1.age = 20;
        System.out.println(p1.toString());
        p1.show();
        //在Person类外部,不能通过Person类的对象调用其内部的私有结构
    }

    //有了反射之后
    @Test
    public void test2() throws Exception {
        Class<Person> aClass = Person.class;
        //1.通过反射创建Person类的对象.
        Constructor<Person> cons = aClass.getDeclaredConstructor(String.class, int.class);
        Person person = cons.newInstance("Tom", 12);
        System.out.println(person.toString());

        //2.通过反射调用对象指定的属性,方法
        Field age = aClass.getDeclaredField("age");
        age.set(person,10);
        System.out.println(person.toString());

        //3.通过反射调用方法
        Method show = aClass.getDeclaredMethod("show");
        show.invoke(person);

        System.out.println("******************************************");

        //4.通过反射,可以调用Person类的私有结构.如: 私有的构造器,方法,属性等
        //调用私有的构造器
        Constructor<Person> cons1 = aClass.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);//
        Person p2 = cons1.newInstance("Jack");
        System.out.println(p2.toString());
        //调用私有属性
        Field name = aClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p2,"Kate");
        System.out.println(p2.toString());
        //调用私有方法
        Method showNation = aClass.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        showNation.invoke(p2,"China");//相当于p2.showNation("China");
    }
    /*
    关于java.lang.Class类的理解
    1.类的加载过程:
        程序在经过javac.exe命令之后,会生出一个或多个字节码文件(.class结尾),接着我们使用java.exe命令
        对某个字节码文件进行解释运行.相当于某个字节码文件加载到内存中.此过程就称为类的加载.
        加载到内存的类,我们就称为运行时类,此运行时类,就作为Class的一个实例.
    2.换句话说,Class的实例就对应着一个运行时类
    3.加载到内存中的运行时类,会缓存一段时间.在此时间之内,我们可以通过不同的方式来获取此运行时类.
     */

    //如何获取Class类的实例: 前三种方式需要掌握,方式三最常使用
    @Test
    public void test3() throws ClassNotFoundException {
        //方式一: 调用运行时类的属性: .class
        Class<Person> clazz1 = Person.class;
        System.out.println(clazz1);
        //方式二: 通过运行时类的对象,调用getClass()
        Person p1 = new Person();
        Class<? extends Person> clazz2 = p1.getClass();
        System.out.println(clazz2);
        //方式三: 调用Class的静态方法: forName(String classPath)
        Class clazz3 = Class.forName("com.shi.java.Person");
        System.out.println(clazz3);
        //
        System.out.println(clazz1 == clazz2); //true

        //方式四: 使用类的加载器: ClassLoader
        ClassLoader loader = ReflectionTest.class.getClassLoader();
        Class clazz4 = loader.loadClass("com.shi.java.Person");
        System.out.println(clazz4);
        System.out.println(clazz1 == clazz4); //true
    }

    //Class实例可以是哪些结构
    @Test
    public void test4(){
        Class c1 = Object.class;
        Class c2 = Comparable.class;
        Class c3 = String[].class;
        Class c4 = int[][].class;
        Class c5 = ElementType.class;
        Class c6 = Override.class;
        Class c7 = int.class;
        Class c8 = void.class;
        Class c9 = Class.class;
        int[] a = new int[10];
        int[] b = new int[100];
        Class c10 = a.getClass();
        Class c11 = b.getClass();
        // 只要元素类型与维度一样，就是同一个Class
        System.out.println(c10 == c11);
    }
}
