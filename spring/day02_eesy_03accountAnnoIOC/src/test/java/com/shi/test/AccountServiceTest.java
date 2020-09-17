package com.shi.test;

import com.shi.domain.Account;
import com.shi.service.IAccountService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author 千文sea
 * @create 2020-09-17 16:28
 *
 * 使用junit单元测试
 */
public class AccountServiceTest {

    private ApplicationContext ac;
    private IAccountService as;

    @Before
    public void init(){
        //1.获取容器
        ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层对象
        as = ac.getBean("accountService",IAccountService.class);
    }

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
