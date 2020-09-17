package com.shi.mybatis.sqlsession;

import com.shi.mybatis.cfg.Configuration;
import com.shi.mybatis.utils.XMLConfigBuilder;
import com.shi.mybatis.sqlsession.defaults.DefaultSqlSessionFactory;

import java.io.InputStream;

/**
 * @author 千文sea
 * @create 2020-09-13 15:58
 *
 * 用于创建一个sqlsessionfactory对象
 */
public class SqlSessionFactoryBuilder {

    /**
     * 根据参数的字节输入流来创建
     * @param config
     * @return
     */
    public SqlSessionFactory build(InputStream config){
        Configuration cfg = XMLConfigBuilder.loadConfiguration(config);

        return  new DefaultSqlSessionFactory(cfg);
    }
}
