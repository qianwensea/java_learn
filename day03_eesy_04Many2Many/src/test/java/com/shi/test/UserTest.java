package com.shi.test;

import com.shi.dao.IUserDao;
import com.shi.domain.Role;
import com.shi.domain.User;
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
public class UserTest {

    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession sqlSession;
    private IUserDao userDao;

    @Before
    public void init() throws Exception{
        //1.读取配置文件,生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory对象
        factory = new SqlSessionFactoryBuilder().build(in);
        //3.获取SqlSession对象
        sqlSession = factory.openSession(true);//自动提交
        //4.获取dao接口的代理对象
        userDao = sqlSession.getMapper(IUserDao.class);
    }

    @After
    public void destroy() throws Exception{
        //提交事务
//        sqlSession.commit();
        //6.关闭资源
        in.close();
        sqlSession.close();
    }

    /**
     * 测试查询的操作
     */
    @Test
    public void testFindAll(){
        List<User> users = userDao.findAll();
        //5.执行查询的方法
        for (User user : users){
            System.out.println("----------每个用户的信息----------");
            System.out.println(user);
            System.out.println(user.getRoles());
        }
    }

    /**
     * 测试查询一个的操作
     */
    @Test
    public void testFindOne(){
        //5.执行查询一个的方法
        System.out.println(userDao.findById(45));
    }

}
