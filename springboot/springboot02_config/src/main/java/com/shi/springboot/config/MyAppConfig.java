package com.shi.springboot.config;

import com.shi.springboot.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author shijinhai
 * @version 1.0
 * @classname: MyAppConfig
 * @description:
 * @date 2020/11/19 16:16
 */

/**
 * 指明当前类是一个配置类
 */
@Configuration
public class MyAppConfig {
    /**
     * 将方法的返回值添加到容器中,默认id就是方法名
     * @return
     */
    @Bean
    public HelloService helloService(){
        System.out.println("往容器中添加helloService...");
        return new HelloService();
    }
}
