package com.shi.java1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * java内置的4大核心函数式接口
 *
 * 消费型接口 Consumer<T>      void accept(T t)
 * 供给型接口 Supplier<T>      T get()
 * 函数型接口 Function<T,R>    R apply(T t)
 * 断定型接口 Predicate<T>     boolean test(T t)
 *
 *
 * @author 千文sea
 * @create 2020-04-09 17:46
 */
public class LambdaTest2 {
    @Test
    public void test1(){
        happyTime(2222, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("学习太累了,出去耍一下,价格为: " + aDouble);
            }
        });
        System.out.println("******************************************");
        happyTime(122,money -> System.out.println("学习太累了,出去耍一下,价格为: " + money));
    }
    public void happyTime(double money, Consumer<Double> con){
        con.accept(money);
    }
    @Test
    public void test2(){
        List<String> list = Arrays.asList("北京", "南京", "天津", "东京", "西京", "普京");
        List<String> list1 = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });
        System.out.println(list1);
        System.out.println("************************************************");
        List<String> list2 = filterString(list, (s) -> s.contains("京"));
        System.out.println(list2);
    }
    //根据给定的规则,过滤集合中的字符串.此规则由Predicate的方法决定
    public List<String> filterString(List<String> str, Predicate<String> pre){
        ArrayList<String> filterList = new ArrayList<>();
        for (String s : str){
            if (pre.test(s)){
                filterList.add(s);
            }
        }
        return filterList;
    }
}
