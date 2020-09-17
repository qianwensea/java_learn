package com.shi.java;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 了解类的加载器
 *
 * @author 千文sea
 * @create 2020-04-08 16:49
 */
public class ClassLoaderTest {
    @Test
    public void test1(){
        //对于自定义类,使用系统类加载器进行加载
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);
        //调用系统类加载的getParent(): 获取扩展类加载器
        ClassLoader classLoader1 = classLoader.getParent();
        System.out.println(classLoader1);
        //调用扩展类加载器的getParent(): 无法获取引导类加载器
        //引导类加载器主要负责加载Java的核心类库,无法加载自定义类
        ClassLoader classLoader2 = classLoader1.getParent();
        System.out.println(classLoader2);

        ClassLoader classLoader3 = String.class.getClassLoader();
        System.out.println(classLoader3);
    }

    /*
    Properties: 用来读取配置文件
     */
    @Test
    public void test2() throws IOException {
        Properties pps = new Properties();
        //此时配置文件在当前module下
        //读取配置文件的方式一:
//        FileInputStream fis = new FileInputStream(new File("jdbc.properties"));
//        FileInputStream fis = new FileInputStream(new File("src\\jdbc1.properties"));
//        pps.load(fis);
        //读取配置文件的方式二:
        //此时配置文件在当前module的src下
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("jdbc1.properties");
        pps.load(is);
        String user = pps.getProperty("user");
        String password = pps.getProperty("password");
        System.out.println("User = " + user + ",password = " + password);
    }
}
