package com.shi.jdbctemplate;

import com.shi.dao.IAccountDao;
import com.shi.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author 千文sea
 * @create 2020-09-22 9:36
 *
 * JdbcTemplateDemo的CRUD
 */
public class JdbcTemplateDemo3 {
    public static void main(String[] args) {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.获取对象
        IAccountDao ad = ac.getBean(IAccountDao.class);
        Account accountById = ad.findAccountById(1);
        System.out.println(accountById);
        accountById.setMoney(109887f);
        ad.updateAccount(accountById);
    }
}