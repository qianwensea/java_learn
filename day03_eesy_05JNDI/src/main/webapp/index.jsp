<%@ page import="java.io.InputStream" %>
<%@ page import="org.apache.ibatis.io.Resources" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactoryBuilder" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactory" %>
<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="com.shi.dao.IUserDao" %>
<%@ page import="com.shi.domain.User" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<html>

<body>
<h2>Hello World!</h2>
<%
    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html; charset=UTF-8");
    //1.读取配置文件
    InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
    //2.根据配置文件构建SqlSessionFactory
    SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
    SqlSessionFactory factory = builder.build(in);
    //3.使用SqlSessionFactory创建SqlSession对象
    SqlSession sqlSession = factory.openSession();
    //4.使用SqlSession构建Dao的代理对象
    IUserDao userDao = sqlSession.getMapper(IUserDao.class);
    //5.执行dao中的findAll方法
    List<User> users = userDao.findAll();
    for(User user : users){
        System.out.println("-----------用户信息-----------");
        System.out.println(user);
    }
    //6.释放资源
    sqlSession.close();
    in.close();
%>
</body>
</html>
