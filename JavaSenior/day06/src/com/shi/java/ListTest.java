package com.shi.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * |---Collection接口: 单列集合,用来储存一个一个的对象
 *  *          |---List接口: 存储有序的,可重复的数据. --> "动态"数组,替换原有的数组
 *  *              |---ArrayList : 作为List的接口的主要实现类, 线程不安全的,效率高; 底层使用Object[] elementData存储
 *                 | LinkedList : 对于频繁的插入,删除操作,使用此类效率比ArrayList高; 底层使用双向链表存储.
 *                 | Vector : 作为List的古老实现类(jdk 1.0就有), 线程安全的,效率不高;底层使用Object[] elementData存储
 *
 *      ArrayList的源码分析:
 *          1. jdk 7情况下
 *              ArrayList list = new ArrayList();//底层创建了长度是10的Object[] elementData数组
 *              list.add(123);//elementData[0] = new Integer(123);
 *              ....
 *              list.add(11);//如果此次的添加导致底层elementData数组容量不够,则扩容.
 *              默认情况下,扩容为原来的容量的1.5倍,同时将原有数组中的数据复制到新的数组中
 *              建议: 开发中尽量使用带参的构造器: ArrayList list = new ArrayList(int capacity)
 *
 *          2. jdk 8情况下
 *              ArrayList list = new ArrayList();//底层Object[] elementData初始化为{};并没有创建长度为10的数组.
 *              list(123);//第一次调用add()时,底层才创建了长度为10的数组,并将数据123添加到elementData中
 *              ....
 *              后续的添加和扩容操作与jdk 7无异.
 *
 *          3. 总结: jdk7中ArrayList的对象的创建类似于单例模式中的饿汉式,jdk8中ArrayList的对象的创建类似于单例模式中的懒汉式
 *
 *      LinkedList的源码分析
 *          LinkedList list = new LinkedList();// 内部声明了Node类型的first和last属性,默认值为null
 *          list(123); //将123封装到Node中,创建了Node对象
 *          其中Node定义为:体现了LinkedList的双向链表的说法
 *          private static class Node<E> {
     *         E item;
     *         Node<E> next;
     *         Node<E> prev;
     *
     *         Node(Node<E> prev, E element, Node<E> next) {
     *             this.item = element;
     *             this.next = next;
     *             this.prev = prev;
     *         }
     *     }
 *
 *
 *      Vector的源码分析:
 *          jdk7和jdk8中通过Vector()构造器创建对象时,底层都创建了长度为10的数组
 *          默认情况下,扩容为原来的容量的2倍.
 *
 *
 *面试题: 比较ArrayList / LinkedList / Vector三者的异同?
 * 同: 都是List的实现类,存储数据的特点相同
 * 异: 见上
 *
 * @author 千文sea
 * @create 2020-04-02 16:13
 */
public class ListTest {
    /*
        void add(int index, Object ele):在index位置插入ele元素
        boolean addAll(int index, Collection eles):从index位置开始将eles中的所有元素添加进来
        Object get(int index):获取指定index位置的元素
        int indexOf(Object obj):返回obj在集合中首次出现的位置
        int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置
        Object remove(int index):移除指定index位置的元素，并返回此元素
        Object set(int index, Object ele):设置指定index位置的元素为ele
        List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex位置的子集合

        总结常用方法:
            增: add(Object obj)
            删: remove(int index)/remove(Object obj)
            改: set(int index,Object ele)
            查: get(int index)
            长度: size()
            遍历: Iterator迭代器 / foreach() / for()
     */
    @Test
    public void test2(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person("Jack",22));

        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        for(Object object : list){
            System.out.println(object);
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
    @Test
    public void test1(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person("Jack",22));

        System.out.println(list);
        //void add(int index, Object ele):在index位置插入ele元素
        list.add(1,"BB");
        System.out.println(list.size());
        //boolean addAll(int index, Collection eles):从index位置开始将eles中的所有元素添加进来
        List list1 = Arrays.asList(1,2,3);
        list.addAll(list1);
        System.out.println(list.size());//8
//
//        Object get(int index):获取指定index位置的元素
        System.out.println(list.get(1));

//        int indexOf(Object obj):返回obj在集合中首次出现的位置
        System.out.println(list.indexOf("BB")); //找不到返回-1

//        int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置
        System.out.println(list.lastIndexOf("AA"));

//        Object remove(int index):移除指定index位置的元素，并返回此元素
        Object remove = list.remove(0);
        System.out.println(remove);
        System.out.println(list);

//        Object set(int index, Object ele):设置指定index位置的元素为ele
        list.set(1,123);
        System.out.println(list);

        //List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex位置的子集合
        List list2 = list.subList(2, 4);
        System.out.println(list);
        System.out.println(list2);
    }
}
