package com.shi.test;

import com.shi.dao.IAccountDao;
import com.shi.dao.IUserDao;
import com.shi.domain.Account;
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
import java.util.List;

/**
 * @author 千文sea
 * @create 2020-09-14 14:59
 */
public class AccountTest {
    private InputStream in;
    private SqlSession sqlSession;
    private SqlSessionFactory factory;
    private IAccountDao accountDao;

    @Before
    public void init() throws Exception{
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = factory.openSession();
        accountDao = sqlSession.getMapper(IAccountDao.class);
    }

    @After
    public void destroy() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }

    @Test
    public void testFindAll(){
        List<Account> accounts = accountDao.findAll();
        for (Account account : accounts){
            System.out.println("-----每个账户的信息-----");
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }
}
