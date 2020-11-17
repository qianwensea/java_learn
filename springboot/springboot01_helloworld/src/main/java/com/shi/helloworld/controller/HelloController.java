package com.shi.helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shijinhai
 * @version 1.0
 * @classname: HelloController
 * @description: TODO
 * @date 2020/11/13 15:57
 */
//这个类的所有方法返回的数据直接写给浏览器
//@ResponseBody
//@Controller
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello world quick!";
    }
}
