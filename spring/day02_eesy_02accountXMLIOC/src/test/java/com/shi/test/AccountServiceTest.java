package com.shi.test;

import com.shi.domain.Account;
import com.shi.service.IAccountService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author 千文sea
 * @create 2020-09-17 16:28
 *
 * 使用junit单元测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
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
