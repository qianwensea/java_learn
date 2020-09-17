package com.shi.dao;

import com.shi.domain.Account;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @author 千文sea
 * @create 2020-09-14 15:43
 */
public interface IAccountDao {

    /**
     * 查询所有账户,并且获取每个账户下所属的用户信息
     * @return
     */
    @Select(value = "select * from account")
    @Results(id = "accountMap",value = {
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "uid",property = "uid"),
            @Result(column = "money",property = "money"),
            @Result(property = "user",column = "uid",one = @One(select="com.shi.dao.IUserDao.findById",fetchType = FetchType. EAGER))
    })
    List<Account> findAll();

    /**
     * 根据uid查询账户
     * @return
     */
    @Select(value = "select * from account where uid = #{userId}")
    @ResultMap(value = {"accountMap"})
    List<Account> findAccountByUid(Integer userId);
}
