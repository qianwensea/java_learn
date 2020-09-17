package com.shi.java1;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.util.ArrayList;

/**
 * 一.注解的使用:
 * 1.从 JDK 5.0 开始, Java 增加了对元数据(MetaData) 的支持, 也就是Annotation(注解)
 * 2.Annotation 其实就是代码里的特殊标记, 这些标记可以在编译, 类加载, 运行时被读取, 并执行相应的处理。通过使用 Annotation, 程序员
 * 可以在不改变原有逻辑的情况下, 在源文件中嵌入一些补充信息。代码分析工具、开发工具和部署工具可以通过这些补充信息进行验证或者进行部署。
 * 3.在JavaSE中，注解的使用目的比较简单，例如标记过时的功能，忽略警告等。在JavaEE/Android中注解占据了更重要的角色，例如
 * 用来配置应用程序的任何切面，代替JavaEE旧版中所遗留的繁冗代码和XML配置等。
 * <p>
 * 二.注解使用的示例:
 * 示例一：生成文档相关的注解
 * 示例二：在编译时进行格式检查(JDK内置的三个基本注解)
 * @Override: 限定重写父类方法, 该注解只能用于方法
 * @Deprecated: 用于表示所修饰的元素(类, 方法等)已过时。通常是因为所修饰的结构危险或存在更好的选择
 * @SuppressWarnings: 抑制编译器警告
 * 示例三：跟踪代码依赖性，实现替代配置文件功能
 * <p>
 * 三.如何自定义注解? 参照@SuppressWarnings来写
 * 注解声明为@interface
 * 内部定义成员,通常使用value来表示
 * 可以指定成员的默认值,通常使用default定义
 *
 * 如果自定义的注解没有成员,表明是一个标识作用
 * 如果注解有成员,在使用注解时,要对成员赋值
 * 自定义注解通常都会指明两个元注解: Retention / Target
 *
 * <p>
 * 四.jdk中的元注解 : JDK 的元 Annotation 用于修饰其他 Annotation 定义
 * Retention 指定该 Annotation 的生命周期(SOURCE/CLASS(默认行为)/RUNTIME)
 *              只有声明为RUNTIME生命周期的注解才能通过反射获取
 * Target : 用于修饰 Annotation 定义, 用于指定被修饰的 Annotation 能用于修饰哪些程序元素。 @Target 也包含一个名为 value 的成员变量。
 * **********下列注解出现频率较低***********
 * Documented : 用于指定被该元 Annotation 修饰的 Annotation 类将被javadoc 工具提取成文档。默认情况下，javadoc是不包括注解的。
 * Inherited : 被它修饰的 Annotation 将具有继承性
 *
 * 五. 通过反射获取注解信息 --- 反射的章节会详细说明
 * 六. jdk 8中注解的
 *      1. 可重复注解
 *          ① 在MyAnnotation上声明注解@Repeatable,成员值为MyAnnotations.class
 *          ② 在MyAnnotation的Target / Retention等元注解 要和在MyAnnotations的需相同
 *
 *      2. 类型注解
 *           ElementType.TYPE_PARAMETER 表示该注解能写在类型变量的声明语句中（如：泛型声明）。
 *           ElementType.TYPE_USE 表示该注解能写在使用类型的任何语句中。
 *
 * @author 千文sea
 * @create 2020-04-01 16:59
 */
public class AnnotationTest {

    public static void main(String[] args) {
        Person p = new Student();
        p.walk();
        @SuppressWarnings("unused")
        int num;
    }

    @Test
    public void testGetAnnotation(){
        Class studentClass = Student.class;
        Annotation[] annotations = studentClass.getAnnotations();
        for (int i = 0; i < annotations.length; i++) {

            System.out.println(annotations[i]); //MyAnnotation(value=hi)
        }
    }
}

//jdk 8之前的写法
//@MyAnnotations({@MyAnnotation("hello"),@MyAnnotation("world")})
//jdk 8之后的写法
@MyAnnotation(value = "hi")
@MyAnnotation(value = "hello")
class Person {
    private String name;
    private int age;

    @MyAnnotation
    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
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

    public void eat() {
        System.out.println("人吃饭");
    }

    public void walk() {
        System.out.println("人走路");
    }
}

interface Info {
    void show();
}

class Student extends Person implements Info {

    @Override
    public void walk() {
        System.out.println("学生走路");
    }

    @Override
    public void show() {

    }
}

class Generic<@MyAnnotation T>{
    public void show() throws @MyAnnotation RuntimeException{
        ArrayList<@MyAnnotation String> list = new ArrayList<>();

        int num = (@MyAnnotation int) 10l;

    }
}