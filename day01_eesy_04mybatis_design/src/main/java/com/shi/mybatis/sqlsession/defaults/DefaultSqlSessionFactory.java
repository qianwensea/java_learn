package com.shi.mybatis.sqlsession.defaults;

import com.shi.mybatis.cfg.Configuration;
import com.shi.mybatis.sqlsession.SqlSession;
import com.shi.mybatis.sqlsession.SqlSessionFactory;

/**
 * @author 千文sea
 * @create 2020-09-13 16:31
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private Configuration cfg;
    public DefaultSqlSessionFactory(Configuration cfg){
        this.cfg = cfg;
    }
    /**
     * 用于创建一个新的操作数据库对象
     * @return
     */
    public SqlSession openSession() {
        return new DefaultSqlSession(cfg);
    }
}
