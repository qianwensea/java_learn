package com.shi.java1;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 1. set接口的框架结构:
 *
 * |---Collection接口: 单列集合,用来储存一个一个的对象
 *  *          |---Set接口: 存储无序的,不可重复的数据. --> 高中讲的"集合"
 *  *              |---HashSet : 作为Set接口的主要实现类, 线程不安全的,可以存储null值
 *                      |---LinkedHashSet : 作为HashSet的子类,使得遍历其内部数据时,可以按照添加的顺序遍历
 *                                           对于频繁的遍历操作,LinkedHashSet的效率比HashSet高
 *                 |---TreeSet : 添加的对象必须是同一个类的对象,可以按照添加对象的指定属性进行排序
 *
 * 2.set接口没有额外定义新的方法,使用的都是Collection中的方法

 * 3. 要求:向Set中添加的数据,其所在类一定要重写hashCode()和equals()
 *          重写的hashCode()和equals()尽可能的保证一致性:“相等的对象必须具有相等的散列码”。
 *                  对象中用作 equals() 方法比较的 Field，都应该用来计算 hashCode 值。
 * @author 千文sea
 * @create 2020-04-02 20:24
 */
public class SetTest {
    /*
    一.Set存储无序,不可重复的数据
      以HashSet为例说明:
        1.无序性: 不等于随机性;存储的数据在底层数组中并非按照数组的索引添加,而是根据数据的哈希值添加

        2.不可重复性: 保证添加的元素按照equals()判断时,不能返回true,即相同的元素只能添加一个

     二. 添加元素的过程: 以HashSet说明: 底层是数组加链表
        我们向HashSet中添加元素a,首先要调用a所在类的hashcode(),计算a的哈希值
        此哈希值接着通过某种算法计算出在HashSet底层数组中的存放位置(即:索引位置),判断
        数组此位置是否已经有元素
            如果此位置上没有其他元素,则a元素添加成功 ---> 情况1
            如果此位置有其他元素b(或以链表形式存在的多个元素),则比较元素a与元素b的哈希值:
                如果hash值不相同,则元素a添加成功 ---> 情况2
                如果hash值相同,则需要调用元素a所在类的equals()方法:
                    equals()返回true,则元素a添加失败
                    equals()返回false,则元素a添加成功 ---> 情况3

           对于情况2和情况3而言: 元素a与已经存在指定索引位置上的元素以链表的方式存储.
                在jdk7中: 元素a放到数组中,指向原来的元素
                在jdk8中: 原来的元素放到数组中,指向元素a    七上八下


     */
    @Test
    public void test1(){
        Set set = new HashSet();
        set.add(123);
        set.add(456);
        set.add("AA");
        set.add("CC");
        set.add(new User("Jack",22));
        set.add(new User("Jack",22)); //与Hashcode有关
        set.add(199);

        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    /*
        LinkedHashSet的使用
            LinkedHashSet作为HashSet的子类,再添加数据的时候,每个数据还维护了两个引用,记录此数据的前后数据
            优点: 对于频繁的遍历操作,LinkedHashSet的效率比HashSet高
     */
    @Test
    public void test2(){
        Set set = new LinkedHashSet();
        set.add(123);
        set.add(456);
        set.add("AA");
        set.add("CC");
        set.add(new User("Jack",22));
        set.add(new User("Jack",22)); //与Hashcode有关
        set.add(199);

        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
