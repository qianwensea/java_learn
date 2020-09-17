package com.shi.dao.impl;

import com.mysql.cj.Session;
import com.shi.dao.IUserDao;
import com.shi.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @author 千文sea
 * @create 2020-09-13 14:31
 */
public class UserDaoIpml implements IUserDao {

    private SqlSessionFactory factory;
    public UserDaoIpml(SqlSessionFactory factory){
        this.factory = factory;
    }
    public List<User> findAll() {
        //1.使用工厂创建sqlsession对象
        SqlSession session = factory.openSession();
        //2.使用session执行查询所有方法
        List<User> users = session.selectList("com.shi.dao.IUserDao.findAll");
        session.close();
        //3.返回查询结果
        return users;
    }
}
