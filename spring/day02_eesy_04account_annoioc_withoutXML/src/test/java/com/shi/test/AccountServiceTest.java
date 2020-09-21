package com.shi.test;

import com.shi.domain.Account;
import com.shi.service.IAccountService;
import config.SpringConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author 千文sea
 * @create 2020-09-17 16:28
 *
 * 使用junit单元测试
 *
 * spring整合junit的配置
 *      1.导入spring整合junit的jar包
 *      2.使用junit提供的注解,把原有的main方法替换了,替换成spring提供的
 *                      Runwith
 *      3.告知spring的运行器,spring的ioc创建是基于xml还是注解的,并且说明位置
 *              @ContextConfiguration
 *                  locations: 指定xml位置,加上classpath关键字,表示在类路径下
 *                  classes: 指定注解类所在的位置
 *      当我们使用spring 5.x版本时后,要求junit的jar包必须是4.1.2及以上
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountServiceTest {
    @Autowired
    private IAccountService as;


    @Test
    public void findAllAccount() {
        //3.执行方法

        List<Account> allAccount = as.findAllAccount();
        for (Account account : allAccount){
            System.out.println(account);
        }
    }

    @Test
    public void findById() {
        Account account = as.findById(2);
        System.out.println(account);
    }

    @Test
    public void saveAccount() {
        Account account = new Account();
        account.setName("def");
        account.setMoney(999.9f);
        as.saveAccount(account);
    }

    @Test
    public void updateAccount() {
        Account account = as.findById(4);
        account.setMoney(88.88f);
        account.setName("ghj");
        as.updateAccount(account);
    }

    @Test
    public void deleteAccount() {
        as.deleteAccount(4);
    }
}
