package com.shi.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 千文sea
 * @create 2020-04-17 20:12
 */
public class ResponseIOServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println(resp.getCharacterEncoding()); ISO-8859-1
//        resp.setCharacterEncoding("UTF-8"); //设置服务器字符集为UTF-8

        // 通过响应头，设置浏览器也使用 UTF-8 字符集
//        resp.setHeader("Content-Type", "text/html; charset=UTF-8");

        // 它会同时设置服务器和客户端都使用 UTF-8 字符集，还设置了响应头
        // 此方法一定要在获取流对象之前调用才有效
        resp.setContentType("text/html; charset=UTF-8"); //推荐使用


        PrintWriter writer = resp.getWriter();
        writer.println("response is content!\n");
        writer.println("你好啊!");

//        ServletOutputStream outputStream = resp.getOutputStream(); //两个流不能同时存在
        /*
        java.lang.IllegalStateException: getWriter() has already been called for this response
	org.apache.catalina.connector.Response.getOutputStream(Response.java:549)
	org.apache.catalina.connector.ResponseFacade.getOutputStream(ResponseFacade.java:210)
	com.shi.servlet.ResponseIOServlet.doGet(ResponseIOServlet.java:19)
	javax.servlet.http.HttpServlet.service(HttpServlet.java:634)
	javax.servlet.http.HttpServlet.service(HttpServlet.java:741)
	org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:53)
         */
    }
}
