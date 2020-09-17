package com.shi.dao.impl;

import com.shi.dao.UserDao;
import com.shi.pojo.User;

/**
 * @author 千文sea
 * @create 2020-09-10 11:24
 */
public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User queryUserByUsername(String username) {
        String sql = "select id,username,password,age from t_user where username = ?";
        return queryForOne(User.class,sql,username);
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select id,username,password,age from t_user where username = ? and password = ?";
        return queryForOne(User.class,sql,username,password);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into t_user(username,password,age) values(?,?,?)";
        return update(sql,user.getUsername(),user.getPassword(),user.getAge());
    }
}
