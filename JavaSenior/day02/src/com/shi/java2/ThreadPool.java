package com.shi.java2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 创建线程方式四: 使用线程池
 *
 * 好处：
 *  提高响应速度（减少了创建新线程的时间）
 *  降低资源消耗（重复利用线程池中线程，不需要每次都创建）
 *  便于线程管理
 *  corePoolSize：核心池的大小
 *  maximumPoolSize：最大线程数
 *  keepAliveTime：线程没有任务时最多保持多长时间后会终止
 *  …
 *
 * 创建多线程有几种方式? 四种
 *
 * @author 千文sea
 * @create 2020-03-29 21:30
 */
class NumbeThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
class NumbeThread1 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if(i % 2 != 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
public class ThreadPool {
    public static void main(String[] args) {
        //1.提供指定线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;
        //设置线程池的属性
//        service1.setCorePoolSize(15);
//        service1.setKeepAliveTime();
        //2.执行指定的线程操作. 此时需要创建Runnable接口或Callable接口实现类的对象
        service.execute(new NumbeThread()); //适合使用于Runnale
        service.execute(new NumbeThread1()); //适合使用于Runnale
//        service.submit(); //适合使用与Callab
        //3.关闭线程池
        service.shutdown();
    }
}
