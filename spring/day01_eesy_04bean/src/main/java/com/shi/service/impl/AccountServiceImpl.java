package com.shi.service.impl;
import com.shi.service.IAccountService;

/**
 * @author 千文sea
 * @create 2020-09-16 10:21
 *
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {
    public AccountServiceImpl(){
        System.out.println("对象创建了");
    }
    public void saveAccount() {
        System.out.println("service中的saveAccount方法执行了...");
    }
    public void init(){
        System.out.println("对象初始化了...");
    }
    public void destroy(){
        System.out.println("对象销毁了...");
    }
}
