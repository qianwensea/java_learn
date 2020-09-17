package com.shi.threadlocal;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author 千文sea
 * @create 2020-05-02 16:16
 */
public class ThreadLocalTest {
    public static final Map<String,Object>data = new Hashtable<>();
    public static ThreadLocal<Object> threadLocal = new ThreadLocal<>();
    private static Random random = new Random();

    public static class Task implements Runnable{

        @Override
        public void run() {
            //在run()中,随机生成一个变量(线程要关联的数据),然后以当前线程名为key保存到Map中
            Integer i = random.nextInt(1000);
            //获取当前线程名
            String name = Thread.currentThread().getName();
            System.out.println("线程[" + name + "],生成的随机数是: " + i);

            data.put(name,i);
            threadLocal.set(i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            OrderService.createOrder();

            //在run()方法快结束之前,以当前线程名为key获取出数据并打印.查看是否可以取出操作
            Object o = data.get(name);
            System.out.println("线程[" + name + "],取出的随机数是: " + o);
        }
    }

    public static void main(String[] args) {
        for (int i = 0;i < 5;i++){
            new Thread(new Task()).start();
        }
    }
}

