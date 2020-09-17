package com.shi.threadlocal;

/**
 * @author 千文sea
 * @create 2020-05-02 16:28
 */
public class OrderService {
    public static void createOrder(){
        String name = Thread.currentThread().getName();
        System.out.println("OrderService 当前线程[" + name + "]中保存的数据是: " + ThreadLocalTest.data.get(name));
        new OrderDao().saveOrder();
    }

    public static class OrderDao {
        public void saveOrder() {
            String name = Thread.currentThread().getName();
            System.out.println("OrderDao 当前线程[" + name + "]中保存的数据是：" + ThreadLocalTest.threadLocal.get());
        }
    }
}
