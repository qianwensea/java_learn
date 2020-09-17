package com.shi.java2;

import com.shi.java1.Person;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 获取运行时类的属性结构
 *
 * @author 千文sea
 * @create 2020-04-08 17:38
 */
public class FiledTest {
    @Test
    public void test1(){
        Class<Person> personClass = Person.class;
        //获取属性结构
        //getFields():获取当前运行时类及其父类中声明为public权限的属性
        Field[] fields = personClass.getFields();
        for (Field f : fields){
            System.out.println(f);
        }

        //getDeclaredFields(): 获取当前运行时类中声明的所有属性(不包含父类中声明的属性)
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field f : declaredFields){
            System.out.println(f);
        }
    }

    //权限修饰符  数据类型  变量名
    @Test
    public void test2(){
        Class<Person> personClass = Person.class;
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field f : declaredFields){
//            System.out.println(f);
            //1.权限修饰符
            int modifiers = f.getModifiers();
            System.out.print(Modifier.toString(modifiers) + "\t");
            //2.数据类型
            Class<?> type = f.getType();
            System.out.print(type.getName() + "\t");
            //3.变量名
            String name = f.getName();
            System.out.println(name);
        }
    }
}
