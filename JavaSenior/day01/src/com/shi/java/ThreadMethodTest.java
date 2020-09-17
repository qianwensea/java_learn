package com.shi.java;

/**
 * 测试Thread中的常用方法"
 * 1.start(): 启动当前线程,调用当前的run()
 * 2.run(): 通常需要重写Thread类中的此方法,将创建的线程要执行的操作声明在此方法中
 * 3.currentThread(): 静态方法,返回当前执行代码的线程
 * 4.getName(): 获取当前线程的名字
 * 5.setName(): 设置当前线程的名字
 * 6.yield():  释放当前CPU的执行权
 * 7.join():   在线程a中调用线程b的join()方法,此时线程a进入阻塞状态,直到线程b执行完毕,线程a才结束阻塞
 * 8.stop():  已过时. 当执行此方法,强制结束当前线程
 * 9.sleep(long millitime):  让线程休眠指定毫秒数的时间. 在指定毫秒数内,当前线程是阻塞状态
 * 10.isAlive(): 判断当前线程是否存活
 *
 * 线程的优先级:
 *   MAX_PRIORITY：10
 *   MIN _PRIORITY：1
 *   NORM_PRIORITY：5 ---> 默认优先级
 * 涉及的方法:
 *   getPriority() ：返回线程优先值
 *   setPriority(int newPriority) ：改变线程的优先级
 * 说明:
 *   线程创建时继承父线程的优先级
 *   低优先级只是获得调度的概率低，并非一定是在高优先级线程之后才被调用
 *
 *
 * @author 千文sea
 * @create 2020-03-28 21:45
 */
class ThreadMethod1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
//                try {
//                    this.sleep(500);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().getPriority() + ":" + i);
            }
            if (i % 20 == 0) {
//                this.yield();
            }
        }
    }

    public ThreadMethod1(String name) {
        super(name);
    }
}

public class ThreadMethodTest {
    public static void main(String[] args) {
        ThreadMethod1 t1 = new ThreadMethod1("Thread-1");
//        t1.setName("线程1");
        //设置分线程的优先级
        t1.setPriority(Thread.MAX_PRIORITY);
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        t1.start();

        //给主线程命名
        Thread.currentThread().setName("主线程");
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().getPriority() + ":" + i);
            }
//            if (i == 20) {
//                try {
//                    t1.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
        }
        System.out.println(t1.isAlive());
    }
}
