package com.shi.test;

import com.shi.dao.IAccountDao;
import com.shi.domain.Account;
import com.shi.domain.AccountUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * @author 千文sea
 * @create 2020-09-14 16:53
 */
public class AccountTest {

    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession sqlSession;
    private IAccountDao accountDao;

    @Before
    public void init() throws Exception{
        //1.读取配置文件,生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory对象
        factory = new SqlSessionFactoryBuilder().build(in);
        //3.获取SqlSession对象
        sqlSession = factory.openSession(true);//自动提交
        //4.获取dao接口的代理对象
        accountDao = sqlSession.getMapper(IAccountDao.class);
    }

    @After
    public void destroy() throws Exception{
        //提交事务
//        sqlSession.commit();
        //6.关闭资源
        in.close();
        sqlSession.close();
    }

    @Test
    public void testFindAll() {
        //5.执行查询方法
        List<Account> accounts = accountDao.findAll();
        for (Account account : accounts){
            System.out.println("------------每个account的信息-----------");
            System.out.println(account);
            System.out.println(account.getUser().toString());
        }
    }
    @Test
    public void testFindAccountUser() {
        //5.执行查询方法
        List<AccountUser> accounts = accountDao.findAllAccount();
        for (Account account : accounts){
            System.out.println(account);
        }
    }

}
