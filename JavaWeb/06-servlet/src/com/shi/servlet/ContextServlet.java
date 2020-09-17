package com.shi.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 千文sea
 * @create 2020-04-17 15:21
 */
public class ContextServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = getServletConfig().getServletContext();
//        1、获取 web.xml 中配置的上下文参数 context-param
        String username = servletContext.getInitParameter("username");
        System.out.println("context-param参数username的值是: " + username);
        System.out.println("context-param参数password的值是: " + servletContext.getInitParameter("password"));
//        2、获取当前的工程路径，格式: /工程路径
        System.out.println("当前工程路径: " + servletContext.getContextPath());
//        3、获取工程部署后在服务器硬盘上的绝对路径
        /**
         * / 斜杠被服务器解析地址为:http://ip:port/工程名/  映射到 IDEA 代码的 web 目录<br/>
         */
        System.out.println("工程部署的路径是:" + servletContext.getRealPath("/"));
        System.out.println("工程下 css 目录的绝对路径是:" + servletContext.getRealPath("/css"));
        System.out.println("工程下 imgs 目录 1.jpg 的绝对路径是:" + servletContext.getRealPath("/imgs/1.jpg"));
    }
}
