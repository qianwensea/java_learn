package com.shi.logindemo.dao;

import com.shi.logindemo.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 千文sea
 * @create 2020-09-20 13:49
 *
 * 用户的持久层接口
 */
@Repository
public interface IUserDao {
    /**
     * 根据用户名和密码查找用户
     * @param username
     * @param password
     * @return
     */
    User findUserByMassege(@Param("username") String username, @Param("password") String password);

    /**
     * 根据用户名查询
     * @param username
     * @return
     */

    User findUserByUsername(@Param("username") String username);
    /**
     * 保存用户
     * @param user
     */
    void saveUser( User user);

    /**
     * 查询所有
     * @return
     */
    List<User> findAll();
}
