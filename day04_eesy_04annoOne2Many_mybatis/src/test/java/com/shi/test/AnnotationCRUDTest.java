package com.shi.test;

import com.shi.dao.IUserDao;
import com.shi.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.jws.soap.SOAPBinding;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @author 千文sea
 * @create 2020-09-14 14:59
 */
public class AnnotationCRUDTest {
    private InputStream in;
    private SqlSession sqlSession;
    private SqlSessionFactory factory;
    private IUserDao userDao;

    @Before
    public void init() throws Exception{
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = factory.openSession();
        userDao = sqlSession.getMapper(IUserDao.class);
    }

    @After
    public void destroy() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }

    @Test
    public void testFindByName(){
        List<User> users = userDao.findUserByName("%王%");
        for (User user : users){
            System.out.println(user);
        }
    }
    @Test
    public void testFindOne(){
        User user1 = userDao.findById(46);
        System.out.println(user1);
//
//        User user2 = userDao.findById(46);
//        System.out.println(user2);
//
//        System.out.println(user1 == user2);
    }
    @Test
    public void testFindAll(){
        List<User> users = userDao.findAll();
        for (User user : users){
            System.out.println("-----每个用户的账户信息-----");
            System.out.println(user);
            System.out.println(user.getAccounts());
        }
    }
}
