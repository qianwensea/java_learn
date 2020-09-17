package com.shi.java;

import java.io.Serializable;

/**
 * Person类要想满足可序列的,需要满足如下的要求
 * 1.需要实现接口Serializable
 * 2.需要提供全局常量serialVersionUID
 * 3.除了当前Person类需要实现Serializable接口外,还必须保证其内部所有属性也必须是可序列化
 *      (默认情况下,基本数据类型也是可序列化的)
 *
 * @author 千文sea
 * @create 2020-04-07 16:24
 */
public class Person implements Serializable {
    public static final long serialVersionUID = 423434382L;
    private String name;
    private int age;
    private Account acc;

    public String getName() {
        return name;
    }

    public Person() {
    }

    public Person(String name, int age, Account acc) {
        this.name = name;
        this.age = age;
        this.acc = acc;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", acc=" + acc +
                '}';
    }
}
class Account implements Serializable{
    public static final long serialVersionUID = 4234342L;
    private int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                '}';
    }
}
