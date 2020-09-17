package com.shi.test;

import com.shi.dao.IUserDao;
import com.shi.domain.QueryVo;
import com.shi.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 千文sea
 * @create 2020-09-14 16:53
 */
public class MybatisTest {

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

    @Test
    public void testFindAll() {
        //5.执行查询方法
        List<User> users = userDao.findAll();
        for (User user : users){
            System.out.println(user);
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

    /**
     * 根据名称模糊查询
     */
    @Test
    public void testFindByUsername(){
        //5.执行查询一个的方法
        List<User> users = userDao.findByUsername("%王%");
//        List<User> users = userDao.findByUsername("王");
        for (User user : users){
            System.out.println(user);
        }
    }

    /**
     * 根据名称模糊查询
     */
    @Test
    public void testFindByQueryVo(){
        QueryVo queryVo = new QueryVo();
        User user = new User();
        user.setUsername("%王%");
        queryVo.setUser(user);
        //5.执行查询一个的方法
        List<User> users = userDao.findUserByVo(queryVo);
        for (User user1 : users){
            System.out.println(user1);
        }
    }

    /**
     * 根据条件查询
     */
    @Test
    public void testFindByCondition(){
        User u = new User();
        u.setUsername("老王");
        u.setSex("男");
        List<User> users = userDao.findUserByCondition(u);
        for (User user1 : users){
            System.out.println(user1);
        }
    }
    /**
     * 测试foreach标签的使用
     */
    @Test
    public void testFindInIds(){
        QueryVo vo = new QueryVo();
        List<Integer> list = new ArrayList<Integer>();
        list.add(47);
        list.add(45);
        list.add(46);
        vo.setIds(list);
        List<User> users = userDao.findUserInIds(vo);
        for (User user1 : users){
            System.out.println(user1);
        }
    }

}
