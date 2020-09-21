package com.shi.service.impl;

import com.shi.service.IAccountService;

/**
 * @author 千文sea
 * @create 2020-09-18 16:41
 *
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {
    public void saveAccount() {
        System.out.println(("执行了保存..."));
//        int i = 1/0;
    }

    public void updateAccount(int i) {
        System.out.println(("执行了更新: ") + i);
    }

    public int deleteAccount() {
        System.out.println(("执行了删除..."));
        return 0;
    }
}
