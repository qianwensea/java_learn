package com.shi.java1;

/**
 * 使用同步机制,将单例模式中的懒汉式改写成线程安全的
 *
 * @author 千文sea
 * @create 2020-03-29 16:26
 */
public class BankTest {
    public static void main(String[] args) {

    }
}

class Bank {
    private Bank() {

    }

    private static Bank instance = null;

    public static synchronized Bank getInstance() {
//   方式一:效率较差     synchronized (Bank.class) {
//            if(instance == null){
//                instance = new Bank();
//            }
//            return instance;
//        }

        //方式二: 效率更高
        if (instance == null) {
            synchronized (Bank.class) {
                if (instance == null) {
                    instance = new Bank();
                }
            }
        }
        return instance;
    }
}