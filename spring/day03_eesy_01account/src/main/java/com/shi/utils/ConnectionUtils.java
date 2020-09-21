package com.shi.utils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author 千文sea
 * @create 2020-09-18 10:24
 *
 * 连接的工具类,它用于从数据源中获取一个连接,并且实现和线程的绑定
 */
public class ConnectionUtils {

    private ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    private DataSource dataSource;

    /**
     * 获取当前线程上的连接
     * @return
     */
    public Connection getThreadLocalConnection(){
        try {
            //1.先从ThreadLocal上获取
            Connection conn = threadLocal.get();
            //2.判断当前线程上是否有连接
            if (conn == null) {
                //3.从数据源中获取一个连接,并且存入ThreadLocal中
                conn = dataSource.getConnection();
                //4.把conn存入ThreadLocal
                threadLocal.set(conn);
                //5,返回当前线程上的连接
            }
            return conn;
        } catch (Exception e) {
                e.printStackTrace();
        }
        return null;
    }

    /**
     * 将线程和连接解绑
     */
    public void removeConnection(){
        threadLocal.remove();
    }
}
