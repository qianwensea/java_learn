package com.shi.mybatis.sqlsession;

/**
 * @author 千文sea
 * @create 2020-09-13 16:01
 *
 * 自定义Mybatis中与数据库交互的核心类
 * 它可以创建dao接口的代理对象
 */
public interface SqlSession {
    /**
     * 根据参数创建一个代理对象
     * @param daoInterfaceClass dao的接口字节码
     * @param <T>
     * @return
     */
    <T> T getMapper(Class<T> daoInterfaceClass);

    /**
     * 释放资源
     */
    void close();
}
