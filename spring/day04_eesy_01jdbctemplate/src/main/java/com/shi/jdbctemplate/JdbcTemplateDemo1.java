package com.shi.jdbctemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * @author 千文sea
 * @create 2020-09-22 9:36
 *
 * JdbcTemplateDemo的基础用法
 */
public class JdbcTemplateDemo1 {
    public static void main(String[] args) {
        //准备数据源: spring的内置数据源
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/eesy?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8");
        ds.setUsername("root");
        ds.setPassword("root");

        //1.创建JdbcTemplate对象
        JdbcTemplate jt = new JdbcTemplate();
        //2.设置数据源
        jt.setDataSource(ds);
        //3.执行操作
        jt.execute(
                "insert into account(name,money) values('rrr',999)"
        );
    }
}
