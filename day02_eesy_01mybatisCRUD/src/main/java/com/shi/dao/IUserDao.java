package com.shi.dao;

import com.shi.domain.QueryVo;
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
     * 查询所有用户
     * @return
     */
    List<User> findAll();

    /**
     * 保存用户
     * @param user
     */
    void saveUser(User user);

    /**
     * 更新用户
     * @param user
     */
    void updateUser(User user);

    /**
     * 根据id删除用户
     * @param userId
     */
    void deleteUser(Integer userId);

    /**
     * 根据id查询用户
     * @param userId
     * @return
     */
    User findById(Integer userId);

    /**
     * 根据名称模糊查询用户
     * @param username
     * @return
     */
    List<User> findByUsername(String username);

    /**
     * 查询用户数量
     * @return
     */
    int findTotal();

    /**
     * 根据queryVo中的查询条件查询用户
     * @param vo
     * @return
     */
    List<User> findUserByVo(QueryVo vo);
}
