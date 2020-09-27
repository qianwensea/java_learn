package com.shi.text;

import com.shi.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 千文sea
 * @create 2020-09-27 16:05
 */
public class TestSpring {

    @Test
    public void test1(){
        //加载spring的配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取对象
        IAccountService accountService = (IAccountService) ac.getBean("accountService");
        //调用方法
        accountService.findAll();
    }
}
