package com.shi.jdbc;

import java.sql.*;

/**
 * @author 千文sea
 * @create 2020-09-16 9:55
 *
 * 程序的耦合
 *      耦合: 程序间的依赖
 *          包括:
 *              类之间的依赖
 *              方法间的依赖
 *
 *      解耦: 降低程序间的依赖
 *      实际开发中:
 *          应该做到,编译器不依赖,运行时才依赖
 *      解耦的思路:
 *          第一步:
 *              使用反射来创建对象,而避免使用new关键字
 *          第二步: 通过读取配置文件来获取要创建的对象的全限定类名
 */
public class JdbcDemo1 {
    public static void main(String[] args) throws SQLException {
        //1.注册驱动
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        //2.获取链接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eesy?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8","root","root");
        //3.获取操作数据库的预处理对象
        PreparedStatement pstm = conn.prepareStatement("select * from account");
        //4.执行sql语句,得到结果集
        ResultSet re = pstm.executeQuery();
        //5.遍历结果集
        while (re.next()){
            System.out.println(re.getString("name"));
        }
        //6.释放资源
        re.close();
        pstm.close();
        conn.close();
    }
}
