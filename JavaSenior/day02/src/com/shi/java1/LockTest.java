package com.shi.java1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 解决线程安全问题的方式三:  Lock锁 ---> JDK5新特性
 *
 * 1.面试题: synchronized与lock的异同?
 *  同: 都是用来解决线程安全问题
 *  异: synchronized机制在执行完相应的同步代码后,自动释放同步监视器
 *      lock需要手动启动同步监视器(lock()),同时结束也需要手动实现(unlock())
 *
 * 2.优先使用顺序：
 * Lock  同步代码块（已经进入了方法体，分配了相应资源）  同步方法（在方法体之外）
 *
 * 3.面试题: 如何解决线程安全问题,有几种?  三种
 *
 * @author 千文sea
 * @create 2020-03-29 17:01
 */
class Window implements Runnable{
    private int ticket = 100;
    //1.实例化ReentrantLock
    private ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        while(true){

            //2.调用lock方法
            lock.lock();
            try {
                if(ticket > 0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":卖票,票号为: " + ticket--);
                }else
                    break;
            }finally {
                //3.调用解锁方法 unlock();
                lock.unlock();
            }
        }
    }
}
public class LockTest {
    public static void main(String[] args) {
        Window w1 = new Window();
        Thread t1 = new Thread(w1);
        Thread t2 = new Thread(w1);
        Thread t3 = new Thread(w1);
        t1.start();
        t2.start();
        t3.start();
    }
}
