package com.shi.controller;

import com.shi.exception.SysException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 千文sea
 * @create 2020-09-24 17:04
 */
@Controller
@RequestMapping("/user")
public class UserController {


    @RequestMapping("/testException")
    public String  testException() throws SysException{
        System.out.println("testException执行了...");
        try {
            //模拟异常
            int i = 10/0;
        } catch (Exception e) {
            //打印异常信息
            e.printStackTrace();
            //抛出自定义异常类
            throw new SysException("查询出错");
        }

        return "success";
    }
}
