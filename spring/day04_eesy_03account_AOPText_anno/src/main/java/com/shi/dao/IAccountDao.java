package com.shi.dao;

import com.shi.domain.Account;

import java.util.List;

/**
 * @author 千文sea
 * @create 2020-09-17 15:58
 *
 * 账户的持久层接口
 */
public interface IAccountDao {
    /**
     * 查询所有
     * @return
     */
    List<Account> findAllAccount();

    /**
     * 查询一个
     * @return account
     */
    Account findById(Integer id);

    /**
     * 保存账户
     * @param account
     */
    void saveAccount(Account account);

    /**
     * 更新账户
     * @param account
     */
    void updateAccount(Account account);

    /**
     * 删除账户
     * @param id
     */
    void deleteAccount(Integer id);

    /**
     * 根据名称查找账户
     * @param accountName
     * @return  如果有唯一的一个结果就返回,如果没有结果返回null
     *           如果结果集超过一个,抛异常
     */
    Account findAccountByName(String accountName);
}
