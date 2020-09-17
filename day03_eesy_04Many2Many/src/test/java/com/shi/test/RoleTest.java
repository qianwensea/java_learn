package com.shi.test;

import com.shi.dao.IRoleDao;
import com.shi.dao.IUserDao;
import com.shi.domain.Role;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.xml.transform.Source;
import java.io.InputStream;
import java.util.List;

/**
 * @author 千文sea
 * @create 2020-09-14 16:53
 */
public class RoleTest {

    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession sqlSession;
    private IRoleDao roleDao;

    @Before
    public void init() throws Exception{
        //1.读取配置文件,生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory对象
        factory = new SqlSessionFactoryBuilder().build(in);
        //3.获取SqlSession对象
        sqlSession = factory.openSession(true);//自动提交
        //4.获取dao接口的代理对象
        roleDao = sqlSession.getMapper(IRoleDao.class);
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
        List<Role> roles = roleDao.findAll();
        //5.执行查询的方法
        for (Role role : roles){
            System.out.println("----------每个角色的信息----------");
            System.out.println(role);
            System.out.println(role.getUsers());
        }
    }

}
