package com.shi.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 集合元素的遍历,使用迭代器Iterator接口
 * 1. 内部的方法: hasNext(), next()
 * 2.集合对象每次调用iterator()方法都得到一个全新的迭代器对象，默认游标都在集合的第一个元素之前。
 * 3. 内部定义了一个remove()方法,可以在遍历时删除元素
 * 注意:如果还未调用next()或在上一次调用 next 方法之后已经调用了 remove 方法，
 *      再调用remove都会报IllegalStateException。
 *
 * @author 千文sea
 * @create 2020-04-02 15:38
 */
public class IteratorTest {
    @Test
    public void test1(){
        Collection coll  = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add("Tom");
        coll.add(false);
        coll.add(new Person("Jack",21));

        Iterator iterator = coll.iterator();
        while(iterator.hasNext())
            System.out.println(iterator.next());
//        iterator.next(); NoSuchElementException
    }
    @Test
    public void test3(){
        Collection coll  = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add("Tom");
        coll.add(false);
        coll.add(new Person("Jack",21));

        Iterator iterator = coll.iterator();
        //删除集合中的"Tom"
        while(iterator.hasNext()){
//            iterator.remove();  IllegalStateException
            Object obj = iterator.next();
            if("Tom".equals(obj)){
                iterator.remove();
            }
//            iterator.remove();  IllegalStateException
        }
        Iterator iterator1 = coll.iterator();
        while(iterator1.hasNext())
            System.out.println(iterator1.next());
    }
}
