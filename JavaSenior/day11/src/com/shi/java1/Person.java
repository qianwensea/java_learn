package com.shi.java1;

/**
 * @author 千文sea
 * @create 2020-04-08 17:26
 */
@MyAnnotation(value = "hi")
public class Person extends Creature<String> implements Comparable<String>,MyInterface{

    private String name;
    int age;
    public int id;

    @MyAnnotation
    public Person() {
    }

    @MyAnnotation(value = "构造器")
    private Person(String name){
        this.name = name;
    }

    Person(String name,int age){
        this.name = name;
        this.age = age;
    }

    @MyAnnotation(value = "getNation方法")
    private String getNation(String nation){
        System.out.println("我的国籍是: " + nation);
        return nation;
    }

    @MyAnnotation
    public String diaplay(String interest,int age) throws NullPointerException,IndexOutOfBoundsException,ClassCastException{
        return interest;
    }

    @Override
    public void info() {
        System.out.println("我是一个人");
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }

    private static void show(){
        System.out.println("我是好人");
    }
}
