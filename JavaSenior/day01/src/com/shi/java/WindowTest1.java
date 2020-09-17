package com.shi.java;

/**
 * 例题: 创建三个窗口卖票,总票数为100(存在线程安全问题,待解决),使用实现Runnable接口的方式
 *
 * @author 千文sea
 * @create 2020-03-28 22:56
 */
class Window1 implements Runnable{
    private  int ticket = 100; //只创建了一个对象,不用加static

    @Override
    public void run() {
        while (true){
            if(ticket > 0){
                System.out.println(Thread.currentThread().getName() + ":卖票,票号为: " + ticket--);
            }else
                break;
        }
    }
}
public class WindowTest1 {
    public static void main(String[] args) {
        Window1 w1 = new Window1();
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
