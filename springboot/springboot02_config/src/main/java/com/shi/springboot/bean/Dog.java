package com.shi.springboot.bean;

/**
 * @author shijinhai
 * @version 1.0
 * @classname: Dog
 * @description: TODO
 * @date 2020/11/13 16:46
 */
public class Dog {

    private String name;

    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
