package com.shi.dao.impl;

import com.shi.dao.IAccountDao;
import com.shi.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * @author 千文sea
 * @create 2020-09-17 16:00
 *
 * 账户的持久层实现类
 */
@Repository(value = "accountDao")
public class AccountDaoImpl implements IAccountDao {

    @Autowired
    private QueryRunner queryRunner;

    public List<Account> findAllAccount() {
        try {
            return queryRunner.query("select * from account",new BeanListHandler<Account>(Account.class));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public Account findById(Integer id) {
        try {
            return queryRunner.query("select * from account where id = ?",new BeanHandler<Account>(Account.class),id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void saveAccount(Account account) {
        try {
            queryRunner.update("insert  into account(name,money) values(?,?)",account.getName(),account.getMoney());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateAccount(Account account) {
        try {
            queryRunner.update("update  into account set name=?,money=? where id=?",account.getName(),account.getMoney(),account.getId());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void deleteAccount(Integer id) {
        try {
            queryRunner.update("delete from account where id=?",id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
