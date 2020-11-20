package com.shi.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shijinhai
 * @version 1.0
 * @classname: HelloController
 * @description: TODO
 * @date 2020/11/19 15:57
 */
@RestController
public class HelloController {

    @Value("${person.last-name}")
    private String name;

    @RequestMapping("/hello")
    public String sayHello(){
        return "hello " + name;
    }
}
