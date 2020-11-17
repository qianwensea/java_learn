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
public class RegistController {
    @Autowired
    private IUserDao userDao;

    @RequestMapping("/regist")
    public Map<String,String> regist(@RequestBody User user){
        System.out.println(user);
        Map<String, String> map = new HashMap<>();
        String flag = "false";
        String  isExistUser = "true";
        try {
            User userFlag = userDao.findUserByUsername(user.getUsername());
            System.out.println(userFlag);
            if (userFlag == null){
                userDao.saveUser(new User(user.getUsername(),user.getPassword()));
                flag = "true";
                isExistUser = "false";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            map.put("flag",flag);
            map.put("isExistUser",isExistUser);
            return map;
        }
    }
}
