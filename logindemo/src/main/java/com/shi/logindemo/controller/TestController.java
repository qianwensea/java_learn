package com.shi.logindemo.controller;

import com.shi.logindemo.dao.IUserDao;
import com.shi.logindemo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 千文sea
 * @create 2020-09-19 21:11
 */
@RestController
public class TestController {
    @Autowired
    private IUserDao userDao;

    @RequestMapping("/test")
    public List<User> test(){
        List<User> users = userDao.findAll();

        return users;
    }
}
