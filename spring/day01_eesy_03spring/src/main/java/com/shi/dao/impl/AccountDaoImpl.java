package com.shi.dao.impl;

import com.shi.dao.IAccountDao;

/**
 * @author 千文sea
 * @create 2020-09-16 10:23
 *
 * 账户的 持久层实现类
 */
public class AccountDaoImpl implements IAccountDao {
    public void saveAccount() {
        System.out.println("保存了账户");
    }
}
