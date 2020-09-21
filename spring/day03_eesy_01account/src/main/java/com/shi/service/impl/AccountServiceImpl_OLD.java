package com.shi.service.impl;

import com.shi.dao.IAccountDao;
import com.shi.domain.Account;
import com.shi.service.IAccountService;
import com.shi.utils.TransactionManager;

import java.util.List;

/**
 * @author 千文sea
 * @create 2020-09-17 15:56
 *
 * 账户的业务层实现类
 *
 * 事务控制放在业务层
 */
public class AccountServiceImpl_OLD implements IAccountService {

    private IAccountDao accountDao;
    private TransactionManager transactionManager;

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> findAllAccount() {

        try {
            //1.开启事务
            transactionManager.beginTransaction();
            //2.执行操作
            List<Account> accounts = accountDao.findAllAccount();
            //3.提交事务
            transactionManager.commitTransaction();
            //4返回结果
            return accounts;
        } catch (Exception e) {
            //回滚事务
            transactionManager.rollbackTransaction();
            throw new RuntimeException(e);

        } finally {
            //6.释放资源
            transactionManager.releaseTransaction();
        }
    }

    public Account findById(Integer id) {
        try {
            //1.开启事务
            transactionManager.beginTransaction();
            //2.执行操作
            Account account = accountDao.findById(id);
            //3.提交事务
            transactionManager.commitTransaction();
            //4返回结果
            return account;
        } catch (Exception e) {
            //回滚事务
            transactionManager.rollbackTransaction();
            throw new RuntimeException(e);
        } finally {
            //6.释放资源
            transactionManager.releaseTransaction();
        }
    }

    public void saveAccount(Account account) {
        try {
            //1.开启事务
            transactionManager.beginTransaction();
            //2.执行操作
            accountDao.saveAccount(account);
            //3.提交事务
            transactionManager.commitTransaction();
            //4返回结果
        } catch (Exception e) {
            //回滚事务
            transactionManager.rollbackTransaction();
        } finally {
            //6.释放资源
            transactionManager.releaseTransaction();
        }
    }

    public void updateAccount(Account account) {
        try {
            //1.开启事务
            transactionManager.beginTransaction();
            //2.执行操作
            accountDao.updateAccount(account);
            //3.提交事务
            transactionManager.commitTransaction();
            //4返回结果
        } catch (Exception e) {
            //回滚事务
            transactionManager.rollbackTransaction();
        } finally {
            //6.释放资源
            transactionManager.releaseTransaction();
        }
    }

    public void deleteAccount(Integer id) {
        try {
            //1.开启事务
            transactionManager.beginTransaction();
            //2.执行操作
            accountDao.deleteAccount(id);
            //3.提交事务
            transactionManager.commitTransaction();
            //4返回结果
        } catch (Exception e) {
            //回滚事务
            transactionManager.rollbackTransaction();
        } finally {
            //6.释放资源
            transactionManager.releaseTransaction();
        }
    }

    public void transfer(String sourceName, String targetName, Float money) {
        try {
            //1.开启事务
            transactionManager.beginTransaction();
            //2.执行操作
            //2.1.根据名称查询转出账户
            Account source = accountDao.findAccountByName(sourceName);
            //2.2.根据名称查询转入账户
            Account target = accountDao.findAccountByName(targetName);
            //2.3.转出账户减钱
            source.setMoney(source.getMoney() - money);
            //2.4.转入账户加钱
            target.setMoney(target.getMoney() + money);
            //2.5.更新转出账户
            accountDao.updateAccount(source);
//            int i = 1/0;
            //2.6.更新转入账户
            accountDao.updateAccount(target);
            //3.提交事务
            transactionManager.commitTransaction();
            //4返回结果
        } catch (Exception e) {
            //回滚事务
            transactionManager.rollbackTransaction();
            e.printStackTrace();
        } finally {
            //6.释放资源
            transactionManager.releaseTransaction();
        }
    }
}
