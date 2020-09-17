package com.shi.java2;

/**
 * 线程通信的例子: 使用两个线程打印 1-100.线程1,线程2交替打印
 *
 * 涉及到的三个方法:
 * wait(): 一旦执行此方法,当前线程就进入阻塞状态,并释放锁
 * notify(): 一旦执行此方法,就会唤醒被wait()的线程,如果有多个线程被wait(),则唤醒优先级高的
 * notifyAll():一旦执行此方法,就会唤醒所有被wait()的方法
 *
 * 说明:
 * 1.wait(),notify(),notifyAll()这三个方法必须使用在同步代码块或同步方法中.
 * 2.这三个方法的调用者,必须是同步代码块或同步方法中的同步监视器
 *      否则会出现java.lang.IllegalMonitorStateException异常
 *
 * 面试题: sleep()和wait()的异同?
 * 1.相同点: 一旦执行方法,都可以让线程进入阻塞
 * 2.不同的: ① 两个方法声明的位置不同: threa类中声明sleep(), Object中声明wait()
 *          ② sleep()方法可以在任何需要的场景下使用. wait()必须使用在同步代码块或同步方法中
 *          ③ 关于是否释放同步监视器 : 如果两个方法都使用在同步代码块或同步监视器中,slepp()不会释放锁,而wait()会释放锁
 *
 * @author 千文sea
 * @create 2020-03-29 19:56
 */
class Number implements Runnable{

    private int number = 1;
    private Object obj = new Object();
    @Override
    public void run() {
        while (true){
            synchronized (obj) {
                obj.notify();
                if(number <= 100){
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + number++);
                }else
                    break;
                try {
                    //使得调用wait()方法的线程进入阻塞状态
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
public class CommunicationTest {
    public static void main(String[] args) {
        Number number = new Number();
        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);
        t1.setName("线程一");
        t2.setName("线程二");
        t1.start();
        t2.start();
    }
}
