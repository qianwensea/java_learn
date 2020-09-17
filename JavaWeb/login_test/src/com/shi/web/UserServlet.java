package com.shi.web;

import com.shi.pojo.User;
import com.shi.service.UserService;
import com.shi.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 千文sea
 * @create 2020-09-10 14:42
 */
public class UserServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if (action.equals("regist")){
            regist(request,response);
        }else {
            login(request,response);
        }

    }
    protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userService.login(new User(username, 12, password, null));
        //3.检查用户名是否正确
        if (userService.isExistUser(username)) {
            //把回显信息保存在request域中
            request.setAttribute("msg", "用户名已存在");
            request.setAttribute("username", username);
            //不可用,跳回注册页面
            System.out.println("用户名[" + username + "]已存在!");
            request.getRequestDispatcher("regist.jsp").forward(request, response);
        } else {
            //可用,将信息保存到数据库
            userService.registUser(new User(username, 12, password, null));
            // 跳到注册成功页面 regist_success.jsp
            request.getRequestDispatcher("regist_success.jsp").forward(request, response);
        }


    }
    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User loginUser = null;
        if (!(username == null || username.equals(""))){
            loginUser= userService.login(new User(username, 12, password, null));
        }
        if (loginUser == null) {
            //用户名或密码错误
//            System.out.println("用户名或密码错误!");
            //把错误信息,和回显表单项信息,保存到request域中
            request.setAttribute("msg", "用户名或密码错误");
            request.setAttribute("username", username);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            //保存用户登录之后的信息到session中
            request.getSession().setAttribute("user", loginUser);
            //登录成功,跳转到登录成功页面
            request.getRequestDispatcher("login_success.jsp").forward(request, response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
