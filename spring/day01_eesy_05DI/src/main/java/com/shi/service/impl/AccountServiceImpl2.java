package com.shi.service.impl;
import com.shi.service.IAccountService;

import java.util.Date;

/**
 * @author 千文sea
 * @create 2020-09-16 10:21
 *
 * 账户的业务层实现类
 */
public class AccountServiceImpl2 implements IAccountService {

    //如果是经常变化的数据,并不适用与注入的方式
    private String name;
    private Integer age;
    private Date birthday;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void saveAccount() {
        System.out.println("service中的saveAccount方法执行了..." + name + "," + age + "," + birthday);
    }
}
