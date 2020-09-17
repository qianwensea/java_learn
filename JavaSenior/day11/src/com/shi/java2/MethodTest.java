package com.shi.java2;

import com.shi.java1.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 获取运行时类的方法结构
 *
 * @author 千文sea
 * @create 2020-04-08 17:51
 */
public class MethodTest {
    @Test
    public void test1(){
        Class<Person> personClass = Person.class;
        //获取所有的方法
        //getMethods():获取当前运行时类及其父类中声明为public权限的方法
        Method[] methods = personClass.getMethods();
        for (Method m : methods){
            System.out.println(m);
        }
        System.out.println("***********************************************");
        ////getDeclaredMethods(): 获取当前运行时类中声明的所方法(不包含父类中声明的方法)
        Method[] declaredMethods = personClass.getDeclaredMethods();
        for (Method m : declaredMethods){
            System.out.println(m);
        }
    }
    /*
    @XXxx
    权限修饰符  返回值类型  方法名(参数类型1 形参1....)  throws XxxxException
     */
    @Test
    public void test2(){
        Class<Person> personClass = Person.class;
        Method[] methods = personClass.getDeclaredMethods();
        for (Method m : methods){
            //1.获取方法的注解
            Annotation[] annotations = m.getAnnotations();
            for (Annotation a : annotations){
                System.out.println(a);
            }
            //2.获取权限修饰符
            System.out.print(Modifier.toString(m.getModifiers()) + "\t");
            //3.返回值类型
            System.out.print(m.getReturnType().getName() + "\t");
            //4.方法名
            System.out.print(m.getName());
            System.out.print("(");
            //5.形参
            Class<?>[] parameterTypes = m.getParameterTypes();
            if (!(parameterTypes == null || parameterTypes.length == 0)){
                for (int i = 0;i < parameterTypes.length;i++){
                    if (i == parameterTypes.length - 1){
                        System.out.print(parameterTypes[i].getName() + "args_" + i);
                        break;
                    }
                    System.out.print(parameterTypes[i].getName() + "args_" + i + ",");
                }
            }
            System.out.print(")");
            //6.抛出的异常
            Class<?>[] exceptionTypes = m.getExceptionTypes();
            if (!(exceptionTypes == null || exceptionTypes.length == 0)){
                System.out.print(" throws ");
                for (int i = 0; i < exceptionTypes.length; i++) {
                    if (i == exceptionTypes.length - 1){
                        System.out.print(exceptionTypes[i].getName());
                    }else
                        System.out.print(exceptionTypes[i].getName() + ",");
                }
            }
            System.out.println();
        }
    }

}
