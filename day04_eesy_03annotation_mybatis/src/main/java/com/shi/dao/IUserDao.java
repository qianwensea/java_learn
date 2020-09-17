package com.shi.dao;

import com.shi.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author 千文sea
 * @create 2020-09-14 11:21
 *
 * 在mybati中针对crud一共有四个注解
 * @Select @Insert @Update @Delete
 */
public interface IUserDao {

    /**
     * 查询所有用户
     * @return
     */
    @Select(value = "select * from user")
    List<User> findAll();

    /**
     * 保存用户
     * @param user
     */
    @Insert(value = "insert into user(username,address,sex,birthday) values(#{username},#{address},#{sex},#{birthday})")
    void saveUser(User user);

    /**
     * 修改用户
     * @param user
     */
    @Update(value = "update user set username=#{username},address=#{address},sex=#{sex},birthday=#{birthday} where id = #{id}")
    void updateUser(User user);

    /**
     * 删除用户
     * @param id
     */
    @Delete(value = "delete from user where id = #{id}")
    void deleteUser(Integer id);

    /**
     * 根据id查询id
     * @param id
     * @return
     */
    @Select(value = "select * from user where id = #{id}")
    User findById(Integer id);

    /**
     * 根据用户名模糊查询
     * @param username
     * @return
     */
    @Select(value = "select * from user where username like #{username}")
    List<User> findUserByName(String username);

    /**
     * 查询总用户数量
     * @return
     */
    @Select(value = "select count(*) from user")
    int findTotal();
}
