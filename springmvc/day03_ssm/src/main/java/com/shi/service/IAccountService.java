package com.shi.service;

import com.shi.domain.Account;

import java.util.List;

/**
 * @author 千文sea
 * @create 2020-09-27 15:53
 *
 * 账户的service接口
 */
public interface IAccountService {

    /**
     * 查询所有账户
     * @return
     */
    public List<Account> findAll();

    /**
     * 保存账户
     */
    public void saveAccount(Account account);

}
