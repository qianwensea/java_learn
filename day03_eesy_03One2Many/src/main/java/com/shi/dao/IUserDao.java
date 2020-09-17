package com.shi.dao;

import com.shi.domain.User;

import java.util.List;

/**
 * @author 千文sea
 * @create 2020-09-14 16:50
 *
 * 用户的持久层接口
 */
public interface IUserDao {

    /**
     * 查询所有用户,同时获取用户下的账户信息
     * @return
     */
    List<User> findAll();

    /**
     * 根据id查询用户
     * @param userId
     * @return
     */
    User findById(Integer userId);
}
