package com.shi.exer;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 银行有一个账户。
 * 有两个储户分别向同一个账户存3000元，每次存1000，存3次。每次存完打
 * 印账户余额。
 * 问题：该程序是否有安全问题，如果有，如何解决？
 * 【提示】
 * 1，明确哪些代码是多线程运行代码，须写入run()方法
 * 2，明确什么是共享数据。
 * 3，明确多线程运行代码中哪些语句是操作共享数据的。
 *
 * @author 千文sea
 * @create 2020-03-29 17:15
 */
class Account {
    private int money;
    private static ReentrantLock Lock = new ReentrantLock();
    public Account(int money) {
        this.money = money;
    }

    //存钱
    public  void deposit(int money){
        if(money > 0){
            try{
                Lock.lock();
                this.money += money;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ":存钱成功,余额为: " + this.money);

            }finally {
                Lock.unlock();
            }
        }
    }
}
class Customer extends Thread{
    private Account account;

    public Customer(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            account.deposit(1000);
        }
    }
}
public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account(0);
        Customer c1 = new Customer(account);
        Customer c2 = new Customer(account);

        c1.setName("线程甲");
        c2.setName("线程已");

        c1.start();
        c2.start();
    }
}
