package com.shi.dao;

import com.shi.domain.Account;
import com.shi.domain.User;

import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 */
public interface IAccountDao {

    /**
     * 查询所有账户，同时还要获取到当前账户的所属用户信息
     * @return
     */
    List<Account> findAll();

    /**
     *
     * @param uid
     * @return
     */
    List<Account> findAccountByUid(Integer uid);

}
