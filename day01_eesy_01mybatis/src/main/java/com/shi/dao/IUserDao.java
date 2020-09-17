package com.shi.dao;

import com.shi.domain.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 千文sea
 * @create 2020-09-11 15:45
 *
 * 用户的持久层接口
 */
public interface IUserDao {
    /**
     * 查询所有操作
     * @return
     */
    List<User> findAll();
}
