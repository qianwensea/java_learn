package com.shi.java;

/**
 * 例题: 创建三个窗口卖票,总票数为100(存在线程安全问题,待解决),使用继承Thread类的方式
 *
 *使用同步代码块,来解决继承Thread类的线程安全问题
 *
 * 说明: 在使用继承Thread类创建多线程的方式中,慎用this来充当同步监视器, 可以考虑用当前类来充当监视器
 *
 * @author 千文sea
 * @create 2020-03-28 22:31
 */
class Window extends Thread{
    private static int ticket = 100;
    private static Object obj = new Object(); //必须要共用一个锁
    @Override
    public void run() {
        while (true){
            //正确的:
//            synchronized (obj) {
            synchronized (Window.class){    //此处的类也是对象   Class c = Window.class

            //错误的:
//            synchronized (this){
                if (ticket > 0) {
                    try {
                        sleep(80);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(getName() + ": 卖票,票号为: " + ticket--);
                } else
                    break;
            }
        }
    }
    public Window(String name){
        super(name);
    }
}

public class WindowTest {
    public static void main(String[] args) {
        Window w1 = new Window("窗口一");
        Window w2 = new Window("窗口二");
        Window w3 = new Window("窗口三");

        w1.start();
        w2.start();
        w3.start();
    }
}
