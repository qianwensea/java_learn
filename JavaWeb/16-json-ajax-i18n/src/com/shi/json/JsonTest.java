package com.shi.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.shi.pojo.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 千文sea
 * @create 2020-09-07 15:21
 */
public class JsonTest {
    //1.2.1、javaBean 和 json 的互转
    @Test
    public void test1(){
        Person person = new Person("shi",1);
        // 创建 Gson 对象实例
        Gson gson = new Gson();
        // toJson 方法可以把 java 对象转换成为 json 字符串
        String personJsonString = gson.toJson(person);
        System.out.println(personJsonString);
        // fromJson 把 json 字符串转换回 Java 对象
        // 第一个参数是 json 字符串
        // 第二个参数是转换回去的 Java 对象类型
        Person jsonToPerson = gson.fromJson(personJsonString, Person.class);
        System.out.println(jsonToPerson);
    }
    // 1.2.2、List 和 json 的互转
    @Test
    public void test2() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("jin",2));
        personList.add(new Person("hai",3));
        Gson gson = new Gson();
        // 把 List 转换为 json 字符串
        String personListToJson = gson.toJson(personList);
        System.out.println(personListToJson);

        //注意json转换回list要新建一个类继承typetoken
        List<Person> list = gson.fromJson(personListToJson,new PersonListType().getType());
        System.out.println(list);
        Person person1 = list.get(0);
        System.out.println(person1);
    }

    // 1.2.3、map 和 json 的互转
     @Test
     public void test3(){
         Map<Integer,Person> personMap = new HashMap<>();
         personMap.put(1, new Person("你好",1));
         personMap.put(2, new Person("世界",2));
         Gson gson = new Gson();
         // 把 map 集合转换成为 json 字符串
         String personMapToJson = gson.toJson(personMap);
         System.out.println(personMapToJson);

         // Map<Integer,Person> personMap2 = gson.fromJson(personMapJsonString, new PersonMapType().getType());
         //使用匿名内部类,减少无用类的创建
         Map<Integer,Person> personMap2 = gson.fromJson(personMapToJson, new TypeToken<HashMap<Integer,Person>>(){}.getType());
         System.out.println(personMap2);
     }
}
