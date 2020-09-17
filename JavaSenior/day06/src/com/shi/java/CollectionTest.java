package com.shi.java;

import org.junit.Test;

import java.util.*;

/**
 * 一. 集合框架的概述
 *
 * 1. 集合,数组都是对多个数据进行存储操作的结构,简称Java容器
 *      说明: 此时的存储,主要指的是内存层面的存储,不涉及到持久化的存储
 *
 * 2.1 数组在存储多个数据方面的特点
 *      > 一旦初始化以后,其长度就确定了
 *      > 一旦定义好,其元素的类型也就确定了. 我们也就只能操作指定类型的数据了

 * 2.1 数组在存储多个数据方面的缺点
 *      > 一旦初始化后,其长度就不能改变
 *      > 数组中提供的方法非常有限,对于添加,删除,插入等操作非常不便,同时效率不高
 *      > 获取数组中实际元素的个数的需求,数组中没有现成的属性或方法可用
 *      > 数组存储数据的特点: 有序,可重复. 对于无序,不可重复的需求,不能满足
 *
 * 二. 集合框架
 *      |---Collection接口: 单列集合,用来储存一个一个的对象
 *          |---List接口: 存储有序的,可重复的数据. --> "动态"数组
 *              |---ArrayList / LinkedList / Vector
 *          |---Set接口: 存储无序的,不可重复的数据. --> 高中讲的"集合"
 *              |---HashSet / LinkedHashSet / TreeSet
 *
 *      |---Map接口: 双列集合,用来存储一对一对(key--value)的数据 --> 高中讲的"函数" y = f(x)
 *              |---HashMap / LinkedMap / TreeMap / Hashtable / Properties
 *
 * 三. Collection接口中方法的使用
 *  1. 向Collection接口的实现类的对象中添加数据obj时,要求obj所在类要重写equals().
 *  2.
 *
 *
 * @author 千文sea
 * @create 2020-04-01 20:20
 */
public class CollectionTest {
    @Test
    public void test1(){
        Collection coll = new ArrayList();
        //1.add(Object e): 将元素e添加到集合coll中
        coll.add("AA");
        coll.add("BB");
        coll.add(123); //自动装箱
        coll.add(new Date());

        //2.size(): 获取添加的元素的个数
        System.out.println(coll.size());//4

        //3.addAll(): 将coll1中的元素添加到当前的集合中
        Collection coll1 = new ArrayList();
        coll1.add(456);
        coll1.add("CC");
        coll.addAll(coll1);
        System.out.println(coll.size());//6
        System.out.println(coll);

        //4.clear(): 清空集合元素
        coll.clear();

        //5.isEmpty(): 判断当前集合是否为空
        System.out.println(coll.isEmpty());

    }
    @Test
    public void test2(){

        Collection coll  = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add("Tom");
        coll.add(false);
        coll.add(new Person("Jack",21));

        //6.contains(Object obj) : 判断当前集合是否包含obj,是通过元素的equals方法来判断是否是同一个对象
        //我们在判断时会调用obj对象所在类的equals()
        boolean contains = coll.contains(123);
        System.out.println(contains);
//        System.out.println(coll.contains(new Person("Jack",21))); //false, 此时没有重写equals方法
        System.out.println(coll.contains(new Person("Jack",21)));

        //7.contiansAll(Collection coll1): 判断coll1中的所有元素是否都在当前集合中
        Collection coll1 = Arrays.asList(123,456);
        System.out.println(coll.containsAll(coll1));
    }

    @Test
    public void test3(){
        Collection coll  = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add("Tom");
        coll.add(false);
        coll.add(new Person("Jack",21));

//        8. remove(Object obj) : 移除指定元素
        System.out.println(coll.remove(1234));
        System.out.println(coll.remove(new Person("Jack",21)));
        //9. removeAll(Collection coll1): 从当前集合中移除coll1中的所有元素
        Collection coll1 = Arrays.asList(123,4567);
        System.out.println(coll.removeAll(coll1));
        System.out.println(coll);
    }
    @Test
    public void test4(){
        Collection coll  = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add("Tom");
        coll.add(false);
        coll.add(new Person("Jack",21));
        //10. retainAll: 取两个集合的交集,将结果保存在当前集合
//        Collection coll1 = Arrays.asList(123,456,789);
//        coll.retainAll(coll1);
//        System.out.println(coll);

        //11 .equals(Object obj) : 判断两个集合的元素是否相同
        Collection coll1  = new ArrayList();
        coll1.add(123);
        coll1.add(456);
        coll1.add("Tom");
        coll1.add(false);
        coll1.add(new Person("Jack",21));
        System.out.println(coll.equals(coll1));
    }
    @Test
    public void test5(){
        Collection coll  = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add("Tom");
        coll.add(false);
        coll.add(new Person("Jack",21));

        //12 hashCode():获取集合对象的哈希值
        System.out.println(coll.hashCode());

        //13 toArray(): 集合 --> 数组
        Object[] objects = coll.toArray();
        for (int i = 0; i < objects.length; i++) {
            System.out.println(objects[i]);
        }
        //扩展 数据 --> 集合 : 调用Arras的静态方法asList()
        List<String> list = Arrays.asList(new String[]{"AA", "BB", "CC", "DD"});
        System.out.println(list);

        List arr1 = Arrays.asList(new int[]{123,456});
        System.out.println(arr1.size()); //1
        List arr2 = Arrays.asList(new Integer[]{123,456});
        System.out.println(arr2.size()); //2

        //14. iterator(): 返回Iterator接口的实例,用于遍历集合的元素

    }

}
