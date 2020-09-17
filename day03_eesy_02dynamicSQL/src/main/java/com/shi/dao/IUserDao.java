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
     * 根据queryVo中的查询条件查询用户
     * @param vo
     * @return
     */
    List<User> findUserByVo(QueryVo vo);

    /**
     * 根据传入的参数条件
     * @param user 查询的条件可能有用户名,或者性别,也有可能有地址,或者都有,或者都没有
     * @return
     */
    List<User> findUserByCondition(User user);

    /**
     * 根据QueryVo中提供的id集合,查询用户信息
     * @param vo
     * @return
     */
    List<User> findUserInIds(QueryVo vo);
}
