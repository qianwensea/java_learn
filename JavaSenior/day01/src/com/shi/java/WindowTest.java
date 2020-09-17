package com.shi.java;

/**
 * 例题: 创建三个窗口卖票,总票数为100(存在线程安全问题,待解决),使用继承Thread类的方式
 *
 * @author 千文sea
 * @create 2020-03-28 22:31
 */
class Window extends Thread{
    private static int ticket = 100;
    @Override
    public void run() {
        while (true){
//            try {
//                sleep(30);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            if(ticket > 0){
                System.out.println(getName() + ": 卖票,票号为: " + ticket--);
            }else
                break;
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
