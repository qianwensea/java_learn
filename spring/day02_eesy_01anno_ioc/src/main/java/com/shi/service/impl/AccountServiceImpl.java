package com.shi.service.impl;

import com.shi.dao.IAccountDao;
import com.shi.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.annotation.Resources;

/**
 * @author 千文sea
 * @create 2020-09-16 10:21
 *
 * 账户的业务层实现类
 *
 * 使用xml的配置
 *  <bean id="accountService" class="com.shi.service.impl.AccountServiceImpl"
 *      scope="" init-method="" destroy-method="">
 *      <property name="" value="" | ref=""></property>
 *  </bean>
 *
 *
 *  用于创建对象的注解
 *       @Component:
 *          作用:用于把当前类对象存入spring容器中
 *          属性:
 *              value用于指定bean的id(当我们不写时,默认名是当前类名,且首字母该为小写)
 *        Controller 表现层
 *        Service 业务层
 *        Repository 持久层
 *        以上三个注解他们的作用和属性与Component是一样的.
 *        他们三个是Spring框架为我们提供明确的三层使用的注解,使我们的三层对象更加清晰
 *      他们的作用就和xml配置文件中编写一个<bean></bean>标签实现的功能是一样的
 *
 *  用于注入的注解
 *      Autowired:
 *          作用: 自动按照类型注入. 只要容器中有唯一的一个bean对象类型和要注入的变量类型匹配,就可以注入成功
 *                  如果ioc容器中没有任何bean类型和要注入的数据变量类型一致的话,则报错.
 *                  如果ioc容器中有多个类型匹配时: 首先根据数据类型筛选再根据变量名确定要注入的对象
 *          出现位置:可以是变量,也可以是方法上
 *          细节:再使用注解注入时,set方法就不是必须的了.
 *      Qualifier:
 *          作用: 在按照类中注入的基础之上再按照名称注入.它在给类成员注入时不能单独使用.但是再给方法参数注入时可以
 *          属性:
 *              用于指定注入bean的id
 *       Resource
 *          作用: 直接按照bean的id注入.它可以独立使用
 *          属性
 *              name: 用于指定bean的id
 *        以上三种注入都只能注入其他bean类型的数据,不能用于基本类型和string类型的注入
 *        另外,集合类型的注入只能通过xml来实现
 *
 *        Value:
 *          作用: 用于注入基本类型和string类型的数据
 *          属性:
 *              value: 用于指定数据的值.它可以使用spring中的SpEL(也就是spring中的EL表达式)
 *                      SpEl的写法:${表达式}
 *
 *
 *      他们的作用就和在xml配置文件中的<bean></bean>标签中写一个<property></property>标签的作用是一样的
 *
 *  用于改变作用范围的
 *
 *      他们的作用就和在xml配置文件中的<bean></bean>标签中使用scope属性实现的功能是一样的
 *
 *      Scope:
 *          作用: 用于指定bean的作用范围
 *          属性:
 *              value: 指定范围的取值. 常用取值: singleton(默认) prototype
 *
 *  和生命周期相关的
 *      他们的作用就和在xml配置文件中的<bean></bean>标签中使用init-method和destroy-method的作用是一样的
 *      PreDestroy
 *          作用: 用于指定销毁方法
 *      PostConstruct
 *          作用: 用于指定初始化方法
 */
@Service(value = "accountService")
@Scope(value = "singleton")
public class AccountServiceImpl implements IAccountService {
//    @Autowired
//    @Qualifier("accountDao2")
    @Resource(name = "accountDao1")
    private IAccountDao accountDao = null;
//    public AccountServiceImpl(){
//        System.out.println("对象创建了");
//    }
    public void saveAccount() {
        accountDao.saveAccount();
    }

    @PostConstruct
    public void init() {
        System.out.println("初始化方法执行了...");
    }
    @PreDestroy
    public void destroy() {
        System.out.println("销毁方法执行了...");
    }
}
