package com.shi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 千文sea
 * @create 2020-09-24 17:04
 */
@Controller
@RequestMapping("/user")
public class UserController {


    @RequestMapping("/testInterceptor")
    public String  testInterceptor(){
        System.out.println("testInterceptor执行了...");

        return "success";
    }
}
