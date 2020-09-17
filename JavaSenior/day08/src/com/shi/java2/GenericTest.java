package com.shi.java2;

import org.junit.Test;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 1. 泛型在继承方面的体现
 *
 *
 * 2. 通配符的使用
 *
 * @author 千文sea
 * @create 2020-04-05 17:17
 */
public class GenericTest {
    /*
        1.泛型在继承方面的体现
            虽然类A是类B的父类, 但G<A>和G<B>二者不具有子父类关系,二者是并列关系
            补充: 类A是类B的父类, A<G>是B<G>父类
     */
    @Test
    public void test1(){
        Object obj = null;
        String str = null;
        obj = str;

        Object[] arr1 = null;
        String[] arr2 = null;
        arr1 = arr2;

        List<Object> list1 = null;
        List<String> list2 = null;
        //此时的list1和list2的类型不具有子父类关系
//        list1 = list2;

    }
    @Test
    public void test2(){
        List<String> list = null;
        ArrayList<String> list1 = null;
        AbstractList<String> list2 = null;
        list = list1;
        list2 = list1;
    }

    /*
        2.通配符的使用
            通配符: ?

         类A是类B的父类, G<A>和G<B>是没有关系的,二者的共同父类是: G<?>
     */

    @Test
    public void test3(){
         List<Object> list1 = null;
         List<String> list2 = null;
         List<?> list = null;
         list = list1;
         list = list2;
         show(list1);
         show(list2);
         //**************
        List<String> list3 = new ArrayList<>();
        list3.add("AA");
        list3.add("BB");
        list3.add("CC");
        list = list3;
        //添加: 对于list<?>就不能向其内部添加数据(除了null)
//        list.add("DD");
        list.add(null);

        //获取: 允许读取数据,读取的数据类型是Object
        Object o = list.get(0);
        System.out.println(o);
    }

    public void show(List<?> list){
        Iterator<?> iterator = list.iterator();
        while (iterator.hasNext()){
            Object next = iterator.next();
            System.out.println(next);
        }
    }
    /*
        3. 有限制的通配符
            ? extends A:
                G<? extends A> 可以作为G<A>和G<B>的父类,其中B 是 A的子类

            ? super A :
                G<? super A> 可以作为G<A>和G<B>的父类,其中B 是 A的父类
     */
    @Test
    public void test4(){
        List<? extends Person> list1 = null;
        List<? super Person> list2 = null;

        List<Student> list3 = new ArrayList<>();
        List<Person> list4 = new ArrayList<>();
        List<Object> list5 = new ArrayList<>();
        list1 = list3;
        list1 = list4;
//        list1 = list5;

//        list2 = list3;
        list2 = list4;
        list2 = list5;
        //读取数据
        list1 = list4;
        Person person = list1.get(0);
//        Student student = list1.get(0);  编译不通过
        list2 = list5;
        Object object = list2.get(0);

        //写入数据
        //编译不通过
//        list1.add(new Student());
        //编译通过
        list2.add(new Person());
        list2.add(new Student());
    }
}
