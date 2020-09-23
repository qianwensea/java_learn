package com.shi.controller;

import com.shi.domain.Account;
import com.shi.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 千文sea
 * @create 2020-09-23 14:54
 *
 * 请求参数绑定
 */
@Controller
@RequestMapping("/param")
public class ParamController {

    /**
     * 请求参数入门
     * @return
     */
    @RequestMapping("/testParam")
    public String testParam(String username,String password){
        System.out.println("执行成功...");
        System.out.println(username);
        System.out.println(password);
        return "success";
    }

    /**
     * 把数据封装到javaBean中
     * @return
     */
    @RequestMapping("saveAccount")
    public String saveAccount(Account account){
        System.out.println("提交成功了: " + account);
        return "success";
    }

    /**
     * 自定义类型转换器
     * @param user
     * @return
     */
    @RequestMapping("saveUser")
    public String saveUser(User user){
        System.out.println("提交成功了: " + user);
        return "success";
    }

    /**
     * 原生的API获取
     * @return
     */
    @RequestMapping("testServlet")
    public String testServlet(HttpServletRequest request, HttpServletResponse response){
        System.out.println("测试成功");
        System.out.println(request);
        System.out.println(request.getSession());
        return "success";
    }

}
