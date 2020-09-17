package com.shi.java1;

import org.junit.Test;

import java.util.*;

/**
 * @author 千文sea
 * @create 2020-04-03 19:13
 */
public class TreeMapTest {
    //向TreeMap中添加key-value,要求key必须是由同一个类创建的对象
    //因为要按照key进行排序: 自然排序,定制排序
    @Test
    public void test1(){
        TreeMap map = new TreeMap();
        User u1 = new User("Jack",22);
        User u2 = new User("Marry",32);
        User u3 = new User("Tom",12);
        User u4 = new User("Jane",42);
        map.put(u1,88);
        map.put(u2,68);
        map.put(u3,44);
        map.put(u4,99);
        Set set1 = map.entrySet();
        Iterator iterator1 = set1.iterator();
        while (iterator1.hasNext()){
            Object obj = iterator1.next();
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + "--->" + entry.getValue());
        }
    }

    //定制排序
    @Test
    public void test2(){
        TreeMap map = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof User&&o2 instanceof User){
                    User u1 = (User)o1;
                    User u2 = (User)o2;
                    return Integer.compare(u1.getAge(),u2.getAge());
                }
                throw new RuntimeException("输入类型不一致");
            }
        });
        User u1 = new User("Jack",22);
        User u2 = new User("Marry",32);
        User u3 = new User("Tom",12);
        User u4 = new User("Jane",42);
        map.put(u1,88);
        map.put(u2,68);
        map.put(u3,44);
        map.put(u4,99);
    }
}
