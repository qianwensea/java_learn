package com.shi.mybatis.sqlsession;

/**
 * @author 千文sea
 * @create 2020-09-13 15:59
 */
public interface SqlSessionFactory {
    /**
     * 用于打开一个新的SqlSession对象
     * @return
     */
    SqlSession openSession();
}
