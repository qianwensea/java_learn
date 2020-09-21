package com.shi.factory;

import com.shi.service.IAccountService;
import com.shi.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author 千文sea
 * @create 2020-09-18 15:49
 *
 * 用于创建Service的代理对象 的工厂
 */
public class BeanFactory {

    private IAccountService accountService;

    private TransactionManager transactionManager;
    public final void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }


    /**
     * 获取service的代理对象
     */
    public IAccountService getAccountService() {
        return (IAccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(), accountService.getClass().getInterfaces(), new InvocationHandler() {
            /**
             * 添加事务的支持
             * @param proxy
             * @param method
             * @param args
             * @return
             * @throws Throwable
             */
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object rtValue = null;
                try {
                    //1.开启事务
                    transactionManager.beginTransaction();
                    //2.执行操作
                    rtValue = method.invoke(accountService, args);
                    //3.提交事务
                    transactionManager.commitTransaction();
                    //4返回结果
                    return rtValue;
                } catch (Exception e) {
                    //回滚事务
                    transactionManager.rollbackTransaction();
                } finally {
                    //6.释放资源
                    transactionManager.releaseTransaction();
                }
                return null;
            }
        });
    }
}
