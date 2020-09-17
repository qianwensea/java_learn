package com.shi.java;

/**
 * 使用同步方法解决继承Thread类的线程安全问题
 *
 * @author 千文sea
 * @create 2020-03-29 16:17
 */
class Window2 extends Thread{
    private static int ticket = 100;
    private static Object obj = new Object(); //必须要共用一个锁
    @Override
    public void run() {
        while (true){
            //正确的:
//            synchronized (obj) {
//            synchronized (Window.class){    //此处的类也是对象   Class c = Window.class

                //错误的:
//            synchronized (this){
                show();
            }
    }
    private static synchronized void show(){ //此时的同步监视器是: Window2.class
//   错误方式: private  synchronized void show(){ //此时的同步监视器是: t1,t2,t3
        if (ticket > 0) {
            try {
                sleep(80);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ": 卖票,票号为: " + ticket--);
        }
    }
    public Window2(String name){
        super(name);
    }
}

public class WindowTest2 {
    public static void main(String[] args) {
        Window2 w1 = new Window2("窗口一");
        Window2 w2 = new Window2("窗口二");
        Window2 w3 = new Window2("窗口三");

        w1.start();
        w2.start();
        w3.start();
    }
}
