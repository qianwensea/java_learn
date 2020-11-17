package com.shi.logindemo.utils;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author 千文sea
 * @create 2020-09-19 21:27
 *
 * 全局配置类,配置跨域请求
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    /**
     * 处理跨域请求
     * 1.预访问的路径
     * 2.请求来源
     * 3.请求的方法
     * 4.允许携带
     * 5.响应最大时间
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("Http://localhost:8080","null")
                .allowedMethods("GET","POST","PUT","OPTION","DELETE").allowCredentials(true).maxAge(3600);
    }
}
