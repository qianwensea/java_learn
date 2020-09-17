package com.shi.exer;

/**
 * 练习: 创建两个分线程,其中一个线程遍历100以内的偶数,另一个线程遍历100以内的奇数
 *
 * @author 千文sea
 * @create 2020-03-28 21:32
 */
public class ThreadExer {
    public static void main(String[] args) {
//        Tread1 t1 = new Tread1();
//        Tread2 t2 = new Tread2();
//        t1.start();
//        t2.start();

        //创建Thread类的匿名子类的方式
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                    }
                }
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i % 2 != 0) {
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                    }
                }
            }
        }.start();
    }
}
//class Tread1 extends Thread{
//    @Override
//    public void run() {
//        for (int i = 0; i < 100; i++) {
//            if(i % 2 == 0) {
//                System.out.println(Thread.currentThread().getName() + ":" + i);
//            }
//        }
//    }
//}
//class Tread2 extends Thread{
//    @Override
//    public void run() {
//        for (int i = 0; i < 100; i++) {
//            if(i % 2 != 0){
//                System.out.println(Thread.currentThread().getName() + ":" + i);
//            }
//        }
//    }
//}