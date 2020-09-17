package com.shi.java1;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author 千文sea
 * @create 2020-04-02 21:20
 */
public class TreeSetTest {
    /*
        1. 向Treeset中添加数据时,要求是同一个类的对象
        2. 两种排序方式: 自然排序(实现Comparable接口)和定制排序(Comparator)
        3. 自然排序中,比较两个对象是否相同的标准为: compareTo()返回 0,不再是equals().
        4. 定制排序中,比较两个对象是否相同的标准为: compare()返回 0,不再是equals().
     */
    @Test
    public void test(){
        TreeSet set = new TreeSet();
//        set.add(123);
//        set.add(456);
//        set.add("AA");
//        System.out.println(set); java.lang.Integer cannot be cast to java.lang.String
        //举例一
//        set.add(22);
//        set.add(444);
//        set.add(777);
//        set.add(111);

        //举例二
        set.add(new User("Jack",22));
        set.add(new User("Jack",55));
        set.add(new User("Tom",22));
        set.add(new User("Mike",22));
        set.add(new User("Bruce",22));
        set.add(new User("Marry",22));
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    @Test
    public void test2(){
        Comparator com = new Comparator() {
            //按照年龄从小到大排序,
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof User && o2 instanceof User){
                    User user1 = (User)o1;
                    User user2 = (User)o2;
                    return Integer.compare(user1.getAge(),user2.getAge());
                }else
                    throw new RuntimeException("输入的类型不一致");
            }
        };
        TreeSet set = new TreeSet(com);
        set.add(new User("Jack",22));
        set.add(new User("Jack",55));
        set.add(new User("Tom",22));
        set.add(new User("Mike",24));
        set.add(new User("Bruce",29));
        set.add(new User("Marry",32));
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next()); //tom被认为一样
        }
    }
}
