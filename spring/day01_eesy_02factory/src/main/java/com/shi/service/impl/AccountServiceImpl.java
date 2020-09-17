package com.shi.service.impl;

import com.shi.dao.IAccountDao;
import com.shi.dao.impl.AccountDaoImpl;
import com.shi.factory.BeanFactory;
import com.shi.service.IAccountService;

/**
 * @author 千文sea
 * @create 2020-09-16 10:21
 *
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {
    private IAccountDao accountDao = BeanFactory.getBean("accountDao");
//    private int i = 0;
    public void saveAccount() {
        int i = 1;
        accountDao.saveAccount();
        System.out.println(i);
        i++;
    }
}
