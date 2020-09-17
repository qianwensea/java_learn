package com.shi.dao;

import com.shi.domain.Account;
import com.shi.domain.AccountUser;

import java.util.List;

/**
 * @author 千文sea
 * @create 2020-09-15 15:14
 */
public interface IAccountDao {

    /**
     * 查询所有账户,同时还要获取当前账户所属用户的信息
     * @return
     */
    List<Account> findAll();

    /**
     * 查询所有账户,并且带有用户名称和地址信息
     * @return
     */
    List<AccountUser> findAllAccount();
}
