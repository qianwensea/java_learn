package com.shi.ui;

import com.shi.dao.IAccountDao;
import com.shi.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 千文sea
 * @create 2020-09-16 10:25
 *
 * 模拟表现层,用于调用业务层
 */
public class Client {
    /**
     * @param args
     */
    public static void main(String[] args) {
        //1.获取核心容器对象
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.根据id获取bean对象
        IAccountService as = (IAccountService) ac.getBean("accountService");
//        IAccountDao ad = (IAccountDao) ac.getBean("accountDao");
        System.out.println(as);
//        System.out.println(ad);
        as.saveAccount();
        ac.close();
    }
}
