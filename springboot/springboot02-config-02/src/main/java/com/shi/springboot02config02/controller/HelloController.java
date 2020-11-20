package com.shi.springboot02config02.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shijinhai
 * @version 1.0
 * @classname: HelloController
 * @description: TODO
 * @date 2020/11/19 16:52
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
}
