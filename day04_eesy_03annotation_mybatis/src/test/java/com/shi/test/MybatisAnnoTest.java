package com.shi.test;

import com.shi.dao.IUserDao;
import com.shi.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author 千文sea
 * @create 2020-09-14 11:33
 */
public class MybatisAnnoTest {
    /**
     * 测试基于注解的Mybatis使用
     * @param args
     */
    public static void main(String[] args) throws Exception {
        //1.获取字节输入流
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.根据字节输入流构建SqlSessionFactory
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.根据sqlsessionfactory生产SqlSession
        SqlSession sqlSession = factory.openSession(true);
        //4.使用sqlSession获取dao的代理对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        //5.执行dao的方法
        List<User> users = userDao.findAll();
        for (User user:users){
            System.out.println(user);
        }
        //6.释放资源
        in.close();
        sqlSession.close();
    }
}
