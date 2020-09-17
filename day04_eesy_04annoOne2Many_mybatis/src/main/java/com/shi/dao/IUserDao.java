package com.shi.dao;

import com.shi.domain.User;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @author 千文sea
 * @create 2020-09-14 11:21
 *
 * 在mybati中针对crud一共有四个注解
 * @Select @Insert @Update @Delete
 */
@CacheNamespace(blocking = true)//开启二级缓存
public interface IUserDao {

    /**
     * 查询所有用户
     * @return
     */
    @Select(value = "select * from user")
    @Results(id = "userMap",value = {
            @Result(id = true,column = "id",property = "userId"),
            @Result(column = "username",property = "userName"),
            @Result(column = "address",property = "userAddress"),
            @Result(column = "sex",property = "userSex"),
            @Result(column = "birthday",property = "userBirthday"),
            @Result(property = "accounts",column = "id",many = @Many(select = "com.shi.dao.IAccountDao.findAccountByUid",fetchType = FetchType.LAZY))
    })
    List<User> findAll();


    /**
     * 根据id查询id
     * @param id
     * @return
     */
    @Select(value = "select * from user where id = #{id}")
    @ResultMap(value = {"userMap"})
    User findById(Integer id);

    /**
     * 根据用户名模糊查询
     * @param username
     * @return
     */
    @Select(value = "select * from user where username like #{username}")
    @ResultMap(value = {"userMap"})
    List<User> findUserByName(String username);

}
