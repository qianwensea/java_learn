package com.shi.service.impl;

import com.shi.dao.IAccountDao;
import com.shi.domain.Account;
import com.shi.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 千文sea
 * @create 2020-09-27 15:54
 */
@Service(value = "accountService")
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDao accountDao;

    @Override
    public List<Account> findAll() {
        System.out.println("业务层,查询所有的账户...");

        return accountDao.findAll();
    }

    @Override
    public void saveAccount(Account account) {
        System.out.println("业务层,保存的账户...");
        accountDao.saveAccount(account);
    }
}
