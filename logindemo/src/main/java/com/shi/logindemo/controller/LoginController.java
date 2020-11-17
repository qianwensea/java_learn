package com.shi.logindemo.controller;

import com.shi.logindemo.dao.IUserDao;
import com.shi.logindemo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 千文sea
 * @create 2020-09-20 13:45
 */
@RestController
public class LoginController {
    @Autowired
    private IUserDao userDao;

    @RequestMapping("/login")
    public Map<String,Object> login(@RequestBody User user){
        System.out.println("user:" + user);
        Map<String,Object> resMap = new HashMap<>();
        User  loginUser = userDao.findUserByMassege(user.getUsername(), user.getPassword());
        String flag = "error";
        if (loginUser != null){
           flag = "ok";
        }
        resMap.put("flag",flag);
        resMap.put("loginUser",loginUser);
        return resMap;
    }
}
