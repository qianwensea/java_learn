package com.shi.service;

import com.shi.domain.Account;

/**
 * @author 千文sea
 * @create 2020-09-22 15:59
 *
 * 账户的业务层接口
 */
public interface IAccountService {

    /**
     * 根据id查询账户
     * @param accountId
     * @return
     */
    Account findAccountById(Integer accountId);

    /**
     * 转账
     * @param sourceName 转出账户名称
     * @param targetName 转入账户名称
     * @param money 转账金额
     */
    void transfer(String sourceName,String targetName,Float money);
}
