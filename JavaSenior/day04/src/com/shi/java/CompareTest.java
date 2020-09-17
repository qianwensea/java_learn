package com.shi.java;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 一.说明:java中的比对象,正常情况下,只能进行比较 ==或!=,不能使用 > 和 < 的
 *          但是开发中,我们需要对多个对象进行排序,言外之意,就需要比较大小
 * 二: 实现方式
 * Java实现对象排序的方式有两种：
 *  自然排序：java.lang.Comparable : 重写方法,可以复用
 *  定制排序：java.util.Comparator : 临时实现,不可复用
 *
 * @author 千文sea
 * @create 2020-03-31 20:47
 */
public class CompareTest {
    /*
        Comparable的使用举例
        1.像String,包装类等实现了Comparable接口,重写了compareTo()方法,给出了比较两个对象大小
        2.像String,包装类等重写了compareTo()方法以后,进行了从小到大的排序
        3.重写compareTo()的规则:
            如果当前对象this大于形参对象obj，则返回正整数，
            如果当前对象this小于形参对象obj，则返回负整数，
            如果当前对象this等于形参对象obj，则返回零。
        4.对于自定义类来说,如果需要排序,我们可以让自定义类实现Comparable接口,重写compareTo(Object o)方法,
        在compareTo(obj)方法中指定如何排序
     */
    @Test
    public void test1(){
        String[] arr = new String[]{"AA","BB","DD","GG","CC"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    @Test
    public void test2(){
        Goods[] goods = new Goods[4];
        goods[0] = new Goods("苹果",934);
        goods[1] = new Goods("华为",634);
        goods[2] = new Goods("三星",734);
        goods[3] = new Goods("小米",334);
        Arrays.sort(goods);
        System.out.println(Arrays.toString(goods));
    }

    /*
        Comparator的使用说明: 定制排序

        当元素的类型没有实现java.lang.Comparable接口而又不方便修改代码，
        或者实现了java.lang.Comparable接口的排序规则不适合当前的操作，那
        么可以考虑使用 Comparator 的对象来排序，强行对多个对象进行整体排序的比较。

         重写compare(Object o1,Object o2)方法，比较o1和o2的大小：如果方法返
        回正整数，则表示o1大于o2；如果返回0，表示相等；返回负整数，表示
        o1小于o2。

         可以将 Comparator 传递给 sort 方法（如 Collections.sort 或 Arrays.sort），
        从而允许在排序顺序上实现精确控制。

         还可以使用 Comparator 来控制某些数据结构（如有序 set或有序映射）的
        顺序，或者为那些没有自然顺序的对象 collection 提供排序。
     */
    @Test
    public void test3(){
        String[] arr = new String[]{"AA","BB","DD","GG","CC"};
        Arrays.sort(arr, new Comparator(){
            //按照字符串从大到小排序
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof String&&o2 instanceof String){
                    String s1 = (String) o1;
                    String s2 = (String) o2;
                    return -s1.compareTo(s2);
                }
                throw new RuntimeException("输入类型不一致");
            }
        });
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test4(){
        Goods[] goods = new Goods[4];
        goods[0] = new Goods("pingguo",934);
        goods[1] = new Goods("huawei",634);
        goods[2] = new Goods("huawei",734);
        goods[3] = new Goods("xiaomi",334);
        Arrays.sort(goods, new Comparator<Goods>() {
            //指明排序的方式: 按照商品名称从低到高,再按照价格从高到低
            @Override
            public int compare(Goods o1, Goods o2) {
                if(o1.getName().equals(o2.getName())){
                    return -Double.compare(o1.getPrice(),o2.getPrice());
                }else
                    return o1.getName().compareTo(o2.getName());
            }
        });
        System.out.println(Arrays.toString(goods));
    }
}
