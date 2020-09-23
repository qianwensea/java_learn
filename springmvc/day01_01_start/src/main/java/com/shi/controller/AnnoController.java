package com.shi.controller;

import com.shi.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;

/**
 * @author 千文sea
 * @create 2020-09-23 15:59
 * <p>
 * 常用注解
 */
@Controller
@RequestMapping("/anno")
@SessionAttributes(value = {"name"})//把msg存入session域中
public class AnnoController {

    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam(name = "username", required = true) String name) {
        System.out.println(name);
        System.out.println("执行成功...");
        return "success";
    }

    /**
     * 获取到请求体的内容
     *
     * @return
     */
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String user) {
        System.out.println(user);
        System.out.println("执行成功...");
        return "success";
    }

    /**
     * testPathVariable
     *
     * @param id
     * @return
     */
    @RequestMapping("/testPathVariable/{id}")
    public String testPathVariable(@PathVariable(value = "id") String id) {
        System.out.println(id);
        System.out.println("执行成功...");
        return "success";
    }

    /**
     * 测试请求头
     *
     * @param header
     * @return
     */
    @RequestMapping(path = "/testRequestHeader")
    public String testRequestHeader(@RequestHeader(value = "Accept") String header) {
        System.out.println(header);
        return "success";
    }

    /**
     * 测试cookie值
     * @param cookieValue
     * @return
     */
    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue(value = "JSESSIONID") String cookieValue) {
        System.out.println(cookieValue);
        return "success";
    }

    /**
     * ModelAttribute注解
     * @return
     */
    @RequestMapping("/testModelAttribute")
    public String  testModelAttribute(@ModelAttribute(value = "1") User user) {
        System.out.println(user);
        System.out.println("testModelAttribute执行了...");
        return "success";
    }


    /**
     * 该方法先执行
     * @param uname
     * @return
     */
    @ModelAttribute
    public void showUser(String uname, Map<String,User> map){
        System.out.println("showUser执行了...");
        //通过用户名查询数据库(模拟)
        User user = new User();
        user.setUname(uname);
        user.setAge(20);
        user.setDate(new Date());
        map.put("1",user);
    }

    /**
     *该方法先执行
     * @param uname
     * @return

    @ModelAttribute
    public User showUser(String uname){
        System.out.println("showUser执行了...");
        //通过用户名查询数据库
        User user = new User();
        user.setUname(uname);
        user.setAge(20);
        user.setDate(new Date());
        return user;
    } */

    /**
     * 测试SessionAttributes
     * @param model
     * @return
     */
    @RequestMapping("/testSessionAttributes")
    public String  testSessionAttributes(Model model) {
        model.addAttribute("name","hehe");
        System.out.println("testSessionAttributes执行了...");
        return "success";
    }

    /**
     * 测试getSessionAttributes
     * @param modelMap
     * @return
     */
    @RequestMapping("/getSessionAttributes")
    public String  getSessionAttributes(ModelMap modelMap) {
        System.out.println("getSessionAttributes执行了...");
        //获取session域中的值
        String name = (String) modelMap.get("name");
        System.out.println(name);
        return "success";
    }

    /**
     * 清除session
     * @param sessionStatus
     * @return
     */
    @RequestMapping("/deleteSessionAttributes")
    public String  deleteSessionAttributes(SessionStatus sessionStatus) {
        System.out.println("deleteSessionAttributes执行了...");
        //删除session域中的值
        sessionStatus.setComplete();
        return "success";
    }
}
