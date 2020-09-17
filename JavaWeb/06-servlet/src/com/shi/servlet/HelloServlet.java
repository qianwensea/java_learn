package com.shi.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author 千文sea
 * @create 2020-04-16 19:09
 */
public class HelloServlet implements Servlet {
    public HelloServlet() {
        System.out.println("1.构造器方法");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("2 init初始化");
//        1、可以获取 Servlet 程序的别名 servlet-name 的值
        String servletName = servletConfig.getServletName();
        System.out.println("HelloServl的别名是: " + servletName);
//        2、获取初始化参数 init-param
        System.out.println("初始化参数username的值是: " + servletConfig.getInitParameter("username"));
        System.out.println("初始化参数url的值是: " + servletConfig.getInitParameter("url"));
//        3、获取 ServletContext 对象
        ServletContext servletContext = servletConfig.getServletContext();
        System.out.println("ServletContext 对象是: " + servletContext);
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * service方法是专门用来处理请求和响应的
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("3 service ==== HelloServlet被访问了");
        //类型转换(因为它才有getmethod()方法)
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        //获取请求方式
        String method = httpServletRequest.getMethod();
        if ("post".equalsIgnoreCase(method)){
            doPost();
        }else if("get".equalsIgnoreCase(method)){
           doGet();
        }
    }

    /**
     * 做get请求的操作
     */
    public void doGet(){
        System.out.println("get请求");
        System.out.println("get请求");
        System.out.println("get请求");
    }

    /**
     * 做post请求的操作
     */
    public void doPost(){
        System.out.println("post请求");
        System.out.println("post请求");
        System.out.println("post请求");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("4 destroy销毁方法");
    }
}
