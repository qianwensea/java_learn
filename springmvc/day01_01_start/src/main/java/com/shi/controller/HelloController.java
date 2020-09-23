package com.shi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author 千文sea
 * @create 2020-09-23 10:32
 *
 * 控制器
 */
@Controller
@RequestMapping("/user")
public class HelloController {
    @RequestMapping(path = "/hello")
    public String sayHello(){
        System.out.println("Hello SpringMVC");
        return "success";
    }

    /**
     * RequestMapping注解
     * @return
     */
    @RequestMapping(value = "/testRequestMapping",method = {RequestMethod.GET},params = {"username=hehe"},headers = {"Accept"})
    public String testRequestMapping(){
        System.out.println("测试RequestMapping注解");
        return "success";
    }

}
