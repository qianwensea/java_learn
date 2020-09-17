package com.shi.java;

/**
 * 创建多线程的方式二: 实现Runnable接口
 * 1.创建一个实现了Runnable接口的类
 * 2.实现类重写Runnable接口中的run()方法
 * 3.创建实现类的对象
 * 4.将此对象作为参数传递到Thread类的构造器中,创建Thread类的对象
 * 5.通过Thread类的对象调用start()
 *
 * 比较创建线程的两种方式:
 * 开发中优先选择实现Runnable接口的方式
 * 原因: 1.实现的方式没有类的单继承的局限性
 *       2.实现的方式更适合来处理多个线程有共享数据的情况
 *
 * 联系:
 * public class Thread implements Runnable
 * 相同点: 两种方式都需要去实现Runnable,重写run(),将线程要执行的内容放在run()中
 *
 * @author 千文sea
 * @create 2020-03-28 22:43
 */
//1.创建一个实现了Runnable接口的类
class RThread implements Runnable{
    //2.实现类重写Runnable接口中的run()方法
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
public class RunnableTest {
    public static void main(String[] args) {
        //3.创建实现类的对象
        RThread r1 = new RThread();
        //4.将此对象作为参数传递到Thread类的构造器中,创建Thread类的对象
        Thread t1 = new Thread(r1);
        //5.通过Thread类的对象调用start()
        t1.start();

        //再启动一个线程,遍历100以内的偶数
        Thread t2 = new Thread(r1);
        t2.start();
    }
}
