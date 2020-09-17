package com.shi.java2;

/**
 * 经典的生产者消费者问题
 *生产者(Productor)将产品交给店员(Clerk)，而消费者(Customer)从店员处
 * 取走产品，店员一次只能持有固定数量的产品(比如:20），如果生产者试图
 * 生产更多的产品，店员会叫生产者停一下，如果店中有空位放产品了再通
 * 知生产者继续生产；如果店中没有产品了，店员会告诉消费者等一下，如
 * 果店中有产品了再通知消费者来取走产品。
 * 这里可能出现两个问题：
 * 生产者比消费者快时，消费者会漏掉一些数据没有取到。
 * 消费者比生产者快时，消费者会取相同的数据。
 *
 * 分析:
 * 1.是否是多线程问题? 是,生产者线程,消费者线程
 * 2.是否有共享数据? 是,产品
 * 3.如何解决线程安全问题? 同步机制,有三种方法
 * 4.是否涉及线程的通信? 是
 * @author 千文sea
 * @create 2020-03-29 20:20
 */
class Clerk{ //店员
    private int product = 0;
    private int id = 0;
    private int id1 = 0;
    //生产产品
    public synchronized void produceProduct() {
        if(product < 20){
            System.out.println(Thread.currentThread().getName() + ":开始生产第" + id++ + "号产品,当前产品数量为:" + ++product + "个");
            notify();
        } else{
            //等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    //消费产品
    public synchronized void consumeProduct() {
        if(product > 0 && id1 <= id){
            System.out.println(Thread.currentThread().getName() + ":开始消费第" + id1++ + "号产品,当前产品数量为:" + --product + "个");
            notify();
        }else{
            //等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Producer extends Thread{ //生产者
    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + ":开始生产产品...");
        while (true){
            try {
                sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.produceProduct();
        }
    }
}
class Customer extends Thread{ //消费者
    private Clerk clerk;

    public Customer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + ":开始消费产品...");
        while(true){
            synchronized (this) {
                try {
                    sleep(400);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                clerk.consumeProduct();
            }
        }
    }
}
public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producer producer = new Producer(clerk);
        Customer customer = new Customer(clerk);
        Customer customer1 = new Customer(clerk);
        producer.setName("生产者一");
        customer.setName("消费者一");
        customer1.setName("消费者二");

        producer.start();
        customer.start();
        customer1.start();
    }
}
