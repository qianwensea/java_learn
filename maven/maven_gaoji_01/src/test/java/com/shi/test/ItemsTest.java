package com.shi.test;

import com.shi.dao.ItemsDao;
import com.shi.domain.Items;
import com.shi.service.ItemsService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 千文sea
 * @create 2020-09-28 16:29
 */
public class ItemsTest {

    @Test
    public void test1(){
        //获取spring容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        //从容器中得到代理对象
        ItemsDao itemsDao = ac.getBean(ItemsDao.class);
        //调用方法
        Items items = itemsDao.findById(1);
        System.out.println(items);
    }

    @Test
    public void testService(){
        //获取spring容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        //从容器中得到代理对象
        ItemsService itemsService = ac.getBean(ItemsService.class);
        System.out.println(itemsService.findById(1));
    }
}
