package com.shi.java;

/**
 * 多线程的创建,方式一: 继承于Thread类
 * 1.创建一个继承于Thread类的子类
 * 2.重写Thread类的run()方法  ---> 将此线程要执行的操作写在run()方法中
 * 3.创建Thread类子类的对象
 * 4.通过此对象调用start()方法
 * <p>
 * 例一:遍历100以内的所以偶数
 *
 * @author 千文sea
 * @create 2020-03-28 17:02
 */

//1. 创建一个继承于Thread类的子类
class MyThread extends Thread {
    //2.重写Thread类的run()方法

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

public class ThreadTest {
    public static void main(String[] args) {
        //创建Thread类子类的对象
        MyThread thread = new MyThread();
        MyThread thread1 = new MyThread();

        //4.通过此对象调用start()方法 :①启动当前线程 ②调用当前线程的run()
        thread.start();
        //问题一: 我们不能通过直接调用run()的方法启动线程
        //thread.run(); 只是调用方法,没有启动新的线程

        //问题二: 再启动一个线程,执行同样操作. 不可以让已经start的线程去执行:java.lang.IllegalThreadStateException
//        thread.start(); java.lang.IllegalThreadStateException
        thread1.start(); //正确方法: 重新创建一个新的线程对象
        //如下操作仍然在主线程(main)中执行的
        for (int i = 0; i < 1000; i++) {
            if(i % 2 != 0){
                System.out.println(Thread.currentThread().getName() + ":" + i + "*");
            }
        }
    }
}
