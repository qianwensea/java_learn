package com.shi.java;

/**
 * 使用同步方法实现Runnable接口解决线程安全问题
 *
 * 关于同步方法的总结:
 * 1. 同步方法仍然涉及到同步监视器,只是不用显式的声明
 * 2. 非静态的同步方法,同步监视器是: this
 * 3. 静态的同步方法,同步监视器是: 当前类本身
 *
 * @author 千文sea
 * @create 2020-03-29 16:10
 */
class Window3 implements Runnable{
    private  int ticket = 100; //只创建了一个对象,不用加static
    Object obj = new Object();
    @Override
    public void run() {
        while (true){
                show();
        }
    }
    private synchronized void show(){ //同步监视器: this
        if (ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":卖票,票号为: " + ticket--);
        }
    }
}

public class WindowTest3 {
    public static void main(String[] args) {
        Window3 w1 = new Window3();
        Thread t1 = new Thread(w1);
        Thread t2 = new Thread(w1);
        Thread t3 = new Thread(w1);
        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");
        t1.start();
        t2.start();
        t3.start();
    }
}
