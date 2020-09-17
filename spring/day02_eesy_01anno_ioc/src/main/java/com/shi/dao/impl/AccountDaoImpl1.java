package com.shi.dao.impl;

import com.shi.dao.IAccountDao;
import org.springframework.stereotype.Repository;

/**
 * @author 千文sea
 * @create 2020-09-16 10:23
 *
 * 账户的 持久层实现类
 */
@Repository(value = "accountDao1")
public class AccountDaoImpl1 implements IAccountDao {
    public void saveAccount() {
        System.out.println("dao1保存了账户");
    }
}
