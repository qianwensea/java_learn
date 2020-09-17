package com.shi.factory;

import com.shi.service.IAccountService;
import com.shi.service.impl.AccountServiceImpl;

/**
 * @author 千文sea
 * @create 2020-09-16 16:51
 *
 * 模拟一个工厂类(该类可能是存在与jar包中的,我们无法通过修改源码的方式来提供默认构造函数)
 */
public class InstanceFactory {
    public IAccountService getAccountService(){
        return new AccountServiceImpl();
    }
}
