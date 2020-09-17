package com.shi.junit;

import com.shi.dao.UserDao;
import com.shi.dao.impl.UserDaoImpl;
import com.shi.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author 千文sea
 * @create 2020-04-19 17:27
 */
public class UserDaoTest {

    @Test
    public void queryUserByUsername() {
        UserDao userDao = new UserDaoImpl();
        if (userDao.queryUserByUsername("admin") == null){
            System.out.println("用户名可用!");
        }else {
            System.out.println("用户名已存在!");
        }
    }

    @Test
    public void saveUser() {
        UserDao userDao = new UserDaoImpl();
        System.out.println(userDao.saveUser(new User("admin",0,"sjh123",null)));
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        UserDao userDao = new UserDaoImpl();
        if (userDao.queryUserByUsernameAndPassword("sjh","123") == null){
            System.out.println("用户名或密码错误,登录失败");
        }else {
            System.out.println("登录成功");
        }
    }
}