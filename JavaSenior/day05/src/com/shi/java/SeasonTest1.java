package com.shi.java;

/**
 *使用enum关键字定义枚举类
 * 说明: 定义的枚举类默认继承与java.lang.Enum类
 *
 *  *三. enum常用的方法
 *  *  values()方法：返回枚举类型的对象数组。该方法可以很方便地遍历所有的枚举值。
 *  *  valueOf(String str)：可以把一个字符串转为对应的枚举类对象。要求字符串必须是枚举类对象的“名字”。如不是，会有运行时异常：IllegalArgumentException。
 *  *  toString()：返回当前枚举类对象常量的名称
 *
 * @author 千文sea
 * @create 2020-04-01 15:20
 */
public class SeasonTest1 {
    public static void main(String[] args) {
        Season1 spring = Season1.SPRING;
        spring.show();
        //toString()
        System.out.println(spring.toString());
//        System.out.println(spring.getClass().getSuperclass());
        //values()
        System.out.println("****************************");
        Season1[] values = Season1.values();
        for(int i = 0;i < values.length;i++){
            System.out.println(values[i]);
        }
        //valuesOf(String objName) : 根据提供的objName,返回与枚举类中对象名是objName的对象
        System.out.println("****************************");
        Season1 winter = Season1.valueOf("WINTER");
        System.out.println(winter);

    }
}
interface Info{
    void show();
}
//使用enum关键字的枚举类
enum Season1 implements Info {
    //1.提供当前枚举类的对象,多个对象之间用,隔开.
     SPRING("春天","春暖花开"){
        @Override
        public void show() {
            System.out.println("我是春天");
        }
    },
     SUMMER("夏天","夏日炎炎"){
         @Override
         public void show() {
             System.out.println("我是夏天");
         }
     },
     AUTUMN("秋天","秋高气爽"){
         @Override
         public void show() {
             System.out.println("我是秋天");
         }
     },
     WINTER("冬天","冰天雪地"){
         @Override
         public void show() {
             System.out.println("我是冬天");
         }
     };


    private final String name;
    private final String seasonDesc;

    //2.私有化类的构造器

    private Season1(String name,String seasonDesc){
        this.name = name;
        this.seasonDesc = seasonDesc;
    }
    //3.提供当前枚举类的多个对象 public static final;

    //4.其他诉求1:获取枚举类对象的属性

    public String getName() {
        return name;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

//    @Override
//    public void show() {
//        System.out.println("这是一个季节");
//    }

//    //4.其他诉求1:提供toString()
//
//    @Override
//    public String toString() {
//        return "Season{" +
//                "name='" + name + '\'' +
//                ", seasonDesc='" + seasonDesc + '\'' +
//                '}';
//    }
}
