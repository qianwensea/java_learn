package com.shi.java2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的方式三: 实现Callable接口. ---> JDK5新特性
 *
 * 如何理解实现Callable接口创建多线程比实现Runnable接口创建多线程的方式要强大?
 * 1.call()可以有返回值
 * 2.call()可以抛出异常,被外面的操作捕获,获取异常信息
 * 3.Callable接口支持泛型
 *
 * @author 千文sea
 * @create 2020-03-29 20:59
 */
//1.创建一个实现Callable接口的实现类
class NumThread implements Callable{
    //2.实现call方法,将此线程要执行的操作声明在call方法中
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= 100 ; i++) {
            if(i % 2 == 0){
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}
public class ThreadNew {
    public static void main(String[] args) {
        //3.创建callable实现类的对象
        NumThread numThread = new NumThread();
        //4.将此callable实现类的对象作为参数传递到FutureTask构造器中,创建FutureTask的对象
        FutureTask futureTask = new FutureTask(numThread);
        //5.将futurtask类的对象作为参数传递到thread类的构造器中,创建Thread类的对象,调用start方法
        new Thread(futureTask).start();

        try {
            //6.获取Callable中call方法的返回值
            //get方法的返回值即为FutureTask构造器参数Callable实现类重写的call()的返回值
            Object sum = futureTask.get();
            System.out.println("总和为:" + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
