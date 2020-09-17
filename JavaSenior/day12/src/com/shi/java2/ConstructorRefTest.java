package com.shi.java2;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 一、构造器引用
 *      和方法引用类似,函数式接口的抽象方法的形参列表和构造器的形参列表一致
 *      抽象方法的返回值类型即为构造器所属的类的类型
 * 二、数组引用
 *      可以把数组看作一个特殊的类,写法即和构造器引用类似
 *
 * Created by shkstart
 */
public class ConstructorRefTest {
	//构造器引用
    //Supplier中的T get()
    @Test
    public void test1(){
        Supplier<Employee> sup = new Supplier<Employee>() {
            @Override
            public Employee get() {
                return new Employee();
            }
        };
        System.out.println(sup.get());
        System.out.println("****************************");
        Supplier<Employee> sup1 = () -> new Employee();
        System.out.println(sup1.get());

        System.out.println("*****************************");
        Supplier<Employee> sup2 = Employee::new;
        System.out.println(sup2.get());
    }

	//Function中的R apply(T t)
    @Test
    public void test2(){
        Function<Integer,Employee> fun = id -> new Employee(id);
        System.out.println(fun.apply(1001));
        System.out.println("*************************");
        Function<Integer,Employee> fun1 = Employee::new;
        System.out.println(fun1.apply(1002));
    }

	//BiFunction中的R apply(T t,U u)
    @Test
    public void test3(){
        BiFunction<Integer,String,Employee> fun = (id,name) -> new Employee(id,name);
        System.out.println(fun.apply(1001, "Tom"));

        System.out.println("*************************");
        BiFunction<Integer,String,Employee> fun1 = Employee::new;
        System.out.println(fun1.apply(1002,"Jack"));
    }

	//数组引用
    //Function中的R apply(T t)
    @Test
    public void test4(){
        Function<Integer,String[]> fun = len -> new String[len];
        String[] arr = fun.apply(5);
        System.out.println(Arrays.toString(arr));
        System.out.println("*************************");
        Function<Integer,String[]> fun1 = String[] :: new;
        String[] arr1 = fun1.apply(6);
        System.out.println(Arrays.toString(arr1));
    }
}
