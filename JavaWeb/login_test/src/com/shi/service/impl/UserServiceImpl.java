package com.shi.service.impl;

import com.shi.dao.UserDao;
import com.shi.dao.impl.UserDaoImpl;
import com.shi.pojo.User;
import com.shi.service.UserService;

/**
 * @author 千文sea
 * @create 2020-09-10 14:38
 */
public class UserServiceImpl implements UserService {

    private UserDao userdao = new UserDaoImpl();

    @Override
    public void registUser(User user) {
        userdao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userdao.queryUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean isExistUser(String username) {
        return userdao.queryUserByUsername(username) == null ? false : true;
    }
}
