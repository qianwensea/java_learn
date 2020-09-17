package com.shi.ui;

import com.shi.factory.BeanFactory;
import com.shi.service.IAccountService;
import com.shi.service.impl.AccountServiceImpl;

/**
 * @author 千文sea
 * @create 2020-09-16 10:25
 *
 * 模拟表现层,用于调用业务层
 */
public class Client {
    public static void main(String[] args) {
//        IAccountService accountService = new AccountServiceImpl();
        for (int i = 0 ;i < 5; i++){
            IAccountService accountService = BeanFactory.getBean("accountService");
            System.out.println(accountService);
            accountService.saveAccount();
        }
    }
}
