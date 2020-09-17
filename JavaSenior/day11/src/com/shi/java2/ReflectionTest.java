package com.shi.java2;

import com.shi.java1.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 调用运行时类指定的结构: 属性,方法,构造器
 *
 * @author 千文sea
 * @create 2020-04-08 20:41
 */
public class ReflectionTest {
    /*
    调用运行时类的属性
     */
    @Test
    public void testField1() throws Exception {
        Class<Person> personClass = Person.class;
        //创建运行时类的对象
        Person p = personClass.newInstance();
        //获取指定的属性 : 要求运行时类的属性声明为public的
        //通常不使用此方法
        Field id = personClass.getField("id");
        /*
        设置当前属性的值:
        set(): 参数一:指明设置当前那个对象的属性   参数二: 将此属性设置为多少
         */
        id.set(p,1001);
        /*
        获取当前属性的值
        get(): 参数一: 获取哪个对象的当前属性值
         */
        int pid = (int)id.get(p);
        System.out.println(pid);
    }

    /*
    如何操作运行时类中指定的属性 -- 需要掌握
     */
    @Test
    public void testField2() throws Exception {
        Class<Person> personClass = Person.class;
        //1.创建运行时类的对象
        Person p = personClass.newInstance();
        //2.获取运行时类指定变量名的属性
        Field name = personClass.getDeclaredField("name");
        //3.保证当前属性是可访问的
        name.setAccessible(true);
        //4.设置,获取指定对象的属性
        name.set(p,"Tom");
//        name.set(Person.class,"Tom"); 调用静态属性的写法
        String str = (String) name.get(p);
        System.out.println(str);
    }

    /*
   如何操作运行时类中指定的方法 -- 需要掌握
    */
    @Test
    public void testMethod1() throws Exception {
        Class<Person> personClass = Person.class;
        //1.创建运行时类的对象
        Person p = personClass.newInstance();
        //2.获取运行时类指定的方法 : 参数一: 指明获取方法的名称 参数二: 指明获取的方法的形参列表
        Method getNation = personClass.getDeclaredMethod("getNation", String.class);
        //3.保证当前方法是可访问的
        getNation.setAccessible(true);
        //4.调用invoke(): 参数1: 方法的调用者  参数2: 传给方法的实参
//                invoke()方法的返回值就是对于类中调用方法的返回值
        Object chn = getNation.invoke(p, "CHN");
        System.out.println(chn);

        System.out.println("*********************如何调用静态方法************************");
        Method show = personClass.getDeclaredMethod("show");
        show.setAccessible(true);
        //如果调用的运行时类中的方法没有返回值,则此invoke()返回null
        Object invoke = show.invoke(Person.class);
//        Object invoke = show.invoke(null);  也可以
        System.out.println(invoke);//null
    }

    /*
    如何调用运行时类的构造器
    1.getDeclaredConstructor()
     */
    @Test
    public void testConstruction() throws Exception{
        Class<Person> personClass = Person.class;
        //private Person(String name)
        Constructor<Person> declaredConstructor = personClass.getDeclaredConstructor(String.class);

        //2.保证此构造器是可访问的
        declaredConstructor.setAccessible(true);
        //3.调用此构造器创建运行时类对象
        Person tom = declaredConstructor.newInstance("Tom");
        System.out.println(tom);
    }
}
