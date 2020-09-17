package com.shi.exer;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * 创建该类的 5 个对象，并把这些对象放入 TreeSet 集合中（下一章：
 * TreeSet 需使用泛型来定义）
 * 分别按以下两种方式对集合中的元素进行排序，并遍历输出：
 * 1). 使 Employee 实现 Comparable 接口，并按 name 排序
 * 2). 创建 TreeSet 时传入 Comparator 对象，按生日日期的先后排序。
 *
 * @author 千文sea
 * @create 2020-04-03 15:18
 */
public class EmployeeTest {
    //1.使用自然排序
    @Test
    public void test1(){
        TreeSet set = new TreeSet();
        Employee e1 = new Employee("Tom",12,new MyDate(2008,2,10));
        Employee e2 = new Employee("Jack",32,new MyDate(1988,4,1));
        Employee e3 = new Employee("Marry",22,new MyDate(1998,8,23));
        Employee e4 = new Employee("Angela",9,new MyDate(2011,11,30));
        Employee e5 = new Employee("Jerr",16,new MyDate(2004,6,14));
        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    //2.使用定制排序
    @Test
    public void test2(){
        TreeSet set = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Employee && o2 instanceof Employee){
                    Employee e1 = (Employee) o1;
                    Employee e2 = (Employee) o2;
                    MyDate d1 = e1.getBirthday();
                    MyDate d2 = e2.getBirthday();
                    int minusYear = d1.getYear() - d2.getYear();
                    if (minusYear != 0){
                        return minusYear;
                    }
                    int minusMonth = d1.getMonth() - d2.getMonth();
                    if(minusMonth != 0){
                        return minusMonth;
                    }
                    return d1.getDay() - d2.getDay();
                }
                throw new RuntimeException("输入类型不一致");
            }
        });
        Employee e1 = new Employee("Tom",12,new MyDate(2008,2,10));
        Employee e2 = new Employee("Jack",32,new MyDate(1988,4,1));
        Employee e3 = new Employee("Marry",22,new MyDate(1998,8,23));
        Employee e4 = new Employee("Angela",9,new MyDate(2011,11,30));
        Employee e5 = new Employee("Jerr",16,new MyDate(2004,6,14));
        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
