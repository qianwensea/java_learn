package com.shi.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 千文sea
 * @create 2020-04-17 15:47
 */
public class ContextServlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        ServletContext servletContext = getServletConfig().getServletContext();
        //获取servletcontex对象
        ServletContext servletContext = getServletContext();
        System.out.println(servletContext);
        //第一次访问时为null,之后就不是,因为整个web工程只有一个servlcontex对象
        System.out.println("保存之前: Context1 获取 key1 的值是:"+ servletContext.getAttribute("key1"));
        //设置属性
        servletContext.setAttribute("key1","value1");
        servletContext.setAttribute("key2","value2");
        servletContext.setAttribute("key3","value3");
        System.out.println("Context1 获取域数据key1 的值是:"+ servletContext.getAttribute("key1"));


    }
}
