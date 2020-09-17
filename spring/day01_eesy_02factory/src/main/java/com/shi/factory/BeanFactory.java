package com.shi.factory;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author 千文sea
 * @create 2020-09-16 10:29
 *
 * 一个创建Bean对象的工厂
 * Bean: 在计算机英语中,有可重用组件的含义
 *
 * JavaBean: 用Java语言编写的可重用组件
 *      JavaBean >> 实体类
 *
 * 它就是创建我们的service和dao对象的
 *
 * 第一个: 需要一个配置文件来配置我们的service和dao
 *      配置内容: 唯一标志 == 全限定类名(key = value)
 * 第二个:通过读取配置文件的内容,反射创建对象
 *
 * 我们的配置文件可以是xml也可以是properties
 */
public class BeanFactory {

    //定义一个properties对象
    private static Properties props;

    //定义一个map,用于存放我们要创建的对象.我们称之为容器
    private static Map<String,Object> beans;

    //使用静态代码块为Properties对象赋值
    static {
        try {
            //实例化对象
            props = new Properties();
            //获取properties的流对象
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            props.load(in);
            //实例化容器
            beans = new HashMap<String, Object>();
            //取出配置文件所有的key
            Enumeration<Object> keys = props.keys();
            //遍历枚举
            while (keys.hasMoreElements()){
                //取出每个key
                String key = keys.nextElement().toString();
                //根据key获取value
                String beanPath = props.getProperty(key);
                Object value = Class.forName(beanPath).newInstance();
                beans.put(key,value);
            }
        } catch (Exception e){
            throw new ExceptionInInitializerError("初始化properties错误");
        }
    }

    /**
     * 根据bean的名称获取对象
     * @param beanName
     * @param <T>
     * @return
     */
    public static <T> T getBean(String beanName){
        return (T) beans.get(beanName);
    }

    /**
     * 根据bean的名称获取Bean对象
     * @param beanName
     * @param <T>
     * @return
     */
//    public static <T> T getBean(String beanName){
//        T bean = null;
//        try {
//            String beanPath = props.getProperty(beanName);
//            bean = (T) Class.forName(beanPath).newInstance(); //每次都会调用默认构造函数创建对象
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return bean;
//    }
}
