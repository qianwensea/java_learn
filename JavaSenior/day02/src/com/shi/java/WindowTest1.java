package com.shi.java;

/**
 * 例题: 创建三个窗口卖票,总票数为100(存在线程安全问题,待解决),使用实现Runnable接口的方式
 *
 *1.问题: 卖票过程中,出现了重票,错票 ---> 出现了线程安全问题
 * 2.问题出现的原因: 当某个线程操作线程的过程中,尚未完成操作时,其他线程参与进来,也操作车票
 * 3.如何解决: 当一个线程操作数据时,其他线程不能参与进来,直到当前线程操作结束,其他线程才能开始操作,
 * 即使当前线程出现了阻塞,也不能改变
 *
 * 4.在Java中我们通过同步机制,来解决线程安全问题.
 * 方式一: 同步代码块
 * synchronized(同步监视器){
 *     //需要被同步的代码
 * }
 *  说明: 操作共享数据的代码,即为需要被同步的代码  ----> 既不能包含少了,也不能包含多了
 *       共享数据: 多个线程共同操作的变量.  如以下的ticket
 *       同步监视器: 俗称锁. 任何一个类的对象都可以用来充当锁
 *                  要求: 多个线程必须共用同一把锁
 *      补充: 在实现Runnable接口创建多线程的方式中,我们可以考虑使用this来充当同步监视器
 *
 * 方式二: 同步方法
 *      如果操作共享数据的代码完整的声明在一个方法中,可以将此方法声明为同步的
 *
 * 5.同步的方式,解决了线程的安全问题. ---> 好处
 *   操作同步代码块时,只能有一个线程参与,其他线程等待. 相当于一个单线程的过程,效率低 ----> 局限性
 *
 *
 * @author 千文sea
 * @create 2020-03-28 22:56
 */
class Window1 implements Runnable{
    private  int ticket = 100; //只创建了一个对象,不用加static
    Object obj = new Object();
    @Override
    public void run() {
        while (true){
            synchronized (this){//此时的this就是唯一的对象,  方式二: //synchronized (obj) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":卖票,票号为: " + ticket--);
                } else
                    break;
            }
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
