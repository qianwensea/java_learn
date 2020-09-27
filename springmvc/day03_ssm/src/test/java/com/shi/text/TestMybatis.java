package com.shi.text;

import com.shi.dao.IAccountDao;
import com.shi.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * @author 千文sea
 * @create 2020-09-27 17:03
 */
public class TestMybatis {
    /**
     * 测试查询所有
     * @throws Exception
     */
    @Test
    public void test1() throws Exception{
        //加载mybatis配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory对象
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //创建sqlsession对象
        SqlSession sqlSession = sessionFactory.openSession();
        //获取到代理对象
        IAccountDao accountDao = sqlSession.getMapper(IAccountDao.class);
        //执行方法
        List<Account> accounts = accountDao.findAll();
        for (Account account : accounts){
            System.out.println(account);
        }
        //关闭资源
        resourceAsStream.close();
        sqlSession.close();
    }

    /**
     * 测试保存
     * @throws Exception
     */
    @Test
    public void test2() throws Exception{
        //加载mybatis配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory对象
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //创建sqlsession对象
        SqlSession sqlSession = sessionFactory.openSession();
        //获取到代理对象
        IAccountDao accountDao = sqlSession.getMapper(IAccountDao.class);
        //执行方法
        Account account = new Account();
        account.setName("小杨");
        account.setMoney(799d);
        accountDao.saveAccount(account);
        //提交事务
        sqlSession.commit();
        //关闭资源
        resourceAsStream.close();
        sqlSession.close();
    }
}
