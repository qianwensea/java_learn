package com.shi.service.impl;
import com.shi.service.IAccountService;

import java.util.Date;

/**
 * @author 千文sea
 * @create 2020-09-16 10:21
 *
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {

    //如果是经常变化的数据,并不适用与注入的方式
    private String name;
    private Integer age;
    private Date birthday;

    public AccountServiceImpl(String name, Integer age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public void saveAccount() {
        System.out.println("service中的saveAccount方法执行了..." + name + "," + age + "," + birthday);
    }
}
