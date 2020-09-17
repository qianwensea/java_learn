package com.shi.test;

import config.SpringConfiguration;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author 千文sea
 * @create 2020-09-17 17:23
 *
 * 测试queryrunner是否是单例的
 */
public class QueryRunnerTest {
    @Test
    public void testQueryRunner() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //获取queryrunner对象
        QueryRunner runner1 = ac.getBean("queryRunner",QueryRunner.class);
        QueryRunner runner2 = ac.getBean("queryRunner",QueryRunner.class);
        System.out.println(runner1 == runner2);
    }

}
