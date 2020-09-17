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

import java.io.IOException;
import java.io.InputStream;

/**
 * @author 千文sea
 * @create 2020-09-14 16:20
 */
public class SecondLevelCacheTest {
    private InputStream in;

    private SqlSessionFactory factory;


    @Before
    public void init() throws Exception{
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);

    }

    @After
    public void destroy() throws IOException {
        in.close();
    }

    @Test
    public void testFindOne(){
        SqlSession sqlSession;
        IUserDao userDao;
        sqlSession = factory.openSession();
        userDao = sqlSession.getMapper(IUserDao.class);
        User user1 = userDao.findById(46);
        System.out.println(user1);

        sqlSession.close();//释放一级缓存

        sqlSession = factory.openSession();//再次打开sqlsession
        IUserDao userDao2 = sqlSession.getMapper(IUserDao.class);
        User user2 = userDao2.findById(46);
        System.out.println(user2);

        System.out.println(user1 == user2);
    }
}
