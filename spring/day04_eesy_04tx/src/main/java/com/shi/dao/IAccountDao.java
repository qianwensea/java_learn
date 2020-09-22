package com.shi.dao;

import com.shi.domain.Account;

/**
 * @author 千文sea
 * @create 2020-09-22 10:59
 *
 * 账户的持久层接口
 */

public interface IAccountDao {

    /**
     * 根据id查询
     * @param id
     * @return
     */
    Account findAccountById(Integer id);

    /**
     * 根据名称查询
     * @param name
     * @return
     */
    Account findAccountByName(String name);

    /**
     * 更新
     * @param account
     */
    void updateAccount(Account account);

}
