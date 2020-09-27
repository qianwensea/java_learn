package com.shi.controller;

import com.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.soap.SOAPBinding;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 千文sea
 * @create 2020-09-24 10:10
 */
@Controller
@RequestMapping("/user")
public class UserController {

    /**
     *
     * @param model
     * @return
     */
    @RequestMapping("/testString")
    public String testString(Model model){
        System.out.println("testString执行了....");
        //模拟从数据库查询出user对象
        User user = new User();
        user.setUsername("小明");
        user.setPassword("123");
        user.setAge(22);
        //model 对象
        model.addAttribute("user",user);
        return "success";
    }

    /**
     * 请求转发一次请求,不用编写项目名称
     * @param request
     * @param response
     */
    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("testVoid执行了....");
        //编写请求转发
//        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);

        //请求重定向
//        response.sendRedirect(request.getContextPath()+"/redirect.jsp");

        //直接响应
            //解决中文乱码
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print("你好啊");
        return;
    }

    /**
     *
     * @return
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        //创建ModelAndView对象
        ModelAndView mv = new ModelAndView();
        System.out.println("testModelAndView执行了....");
        //模拟从数据库查询出user对象
        User user = new User();
        user.setUsername("小明");
        user.setPassword("123");
        user.setAge(22);
        //把user对象存储到mv对象中,也会把user对象存入request域中
        mv.addObject("user",user);
        //跳转到哪个页面
        mv.setViewName("success");
        return mv;
    }

    /**
     * 使用关键字的方式来进行转发或者重定向
     * @return
     */
    @RequestMapping("/testForwardOrRedirect")
    public String testForwardOrRedirect(){
        System.out.println("testForwardOrRedirect执行了....");
        //请求的转发
//        return "forward:/WEB-INF/pages/success.jsp";

        //请求重定向
        return "redirect:/redirect.jsp";
    }

    /**
     * 模拟异步请求与响应
     */
    @RequestMapping("/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user){
        System.out.println("testAjax执行了....");
        //客户端发送ajax请求,传的是json字符串,后端把json字符串封装到user对象中
        System.out.println(user);
        //作出响应,模拟响应数据库
        user.setUsername("小李");
        user.setAge(12);
        return user;
    }
}
