package com.shi.dao;

import com.shi.pojo.User;

/**
 * @author 千文sea
 * @create 2020-09-10 11:16
 */
public interface UserDao {
    /**
     * 查询用户信息
     */
    public User queryUserByUsername(String username);

    /**
     * 保存用户
     */
    public int saveUser(User user);

    /**
     * 通过用户名和密码查询
     */
    public User queryUserByUsernameAndPassword(String username,String password);
}
