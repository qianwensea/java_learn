package com.shi.service;

import com.shi.pojo.User;

/**
 * @author 千文sea
 * @create 2020-09-10 14:35
 */
public interface UserService {
    public void registUser(User user);
    public User login(User user);
    public boolean isExistUser(String username);

}
