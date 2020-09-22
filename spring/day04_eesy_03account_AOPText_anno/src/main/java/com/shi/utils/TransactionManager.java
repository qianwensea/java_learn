package com.shi.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * @author 千文sea
 * @create 2020-09-18 10:33
 *
 * 事务管理相关的工具类,它包含了: 开启事务,提交事务,回滚事务和释放连接
 */
@Component("transactionManager")
@Aspect
public class TransactionManager {

    @Autowired
    private ConnectionUtils connectionUtils;

    @Pointcut("execution(* com.shi.service.impl.*.*(..))")
    private void pt1(){};

    /**
     * 开启事务
     */
    public void beginTransaction(){
        try {
            connectionUtils.getThreadLocalConnection().setAutoCommit(false);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    /**
     * 提交事务
     */
    public void commitTransaction(){
        try {
            connectionUtils.getThreadLocalConnection().commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    /**
     * 回滚事务
     */
    public void rollbackTransaction(){
        try {
            connectionUtils.getThreadLocalConnection().rollback();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    /**
     * 释放连接
     */
    public void releaseTransaction(){
        try {
            connectionUtils.getThreadLocalConnection().close(); //还回连接池中
            connectionUtils.removeConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * 环绕通知
     * @param pjp
     * @return
     */
    @Around("pt1()")
    public Object aroundAdvice(ProceedingJoinPoint pjp){
        Object rtValue = null;
        try {
            //1.获取 参数
            Object[] args = pjp.getArgs();
            //2.开启事务
            this.beginTransaction();
            //3.执行方法
            rtValue = pjp.proceed(args);
            //4.提交事务
            this.commitTransaction();
            //返回结果
            return rtValue;
        } catch (Throwable e) {
            //5.回滚事务
            this.rollbackTransaction();
            throw new RuntimeException(e);
        } finally {
            //6.释放资源
            this.releaseTransaction();
        }
    }
}
