package com.shi.servlet;

import com.shi.utils.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Base64;

/**
 * @author 千文sea
 * @create 2020-04-27 19:34
 */
public class CookieServlet extends BaseServlet {

    protected void updateCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 方案一：
        // 1、先创建一个要修改的同名的 Cookie 对象
        // 2、在构造器，同时赋于新的 Cookie 值。
        Cookie cookie = new Cookie("key1", "newValue1");
        // 3、调用 response.addCookie( Cookie ); 通知 客户端 保存修改
        resp.addCookie(cookie);
        resp.getWriter().write("key1的cookie值已经修改好了<br/>");

        // 方案二：
        // 1、先查找到需要修改的 Cookie 对象
        Cookie cookie1 = CookieUtils.findCookie("key2", req.getCookies());
        if (cookie1 != null) {
            // 2、调用 setValue()方法赋于新的 Cookie 值。
            cookie1.setValue("newValue2");
            // 3、调用 response.addCookie()通知客户端保存修改
            resp.addCookie(cookie1);
            resp.getWriter().write("key2的cookie值已经修改好了");
        }

    }

    protected void getCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //解决post请求中文乱码问题
        req.setCharacterEncoding("UTF-8");
        //解决中文乱码问题
        resp.setContentType("text/html;charset=UTF-8");

        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            //getName()方法返回Cookie的key
            //getValue()方法返回Cookie的value值
            resp.getWriter().println("Cookie[" + cookie.getName() + "=" + cookie.getValue() + "]<br/>");
        }

        Cookie iWantCookie = CookieUtils.findCookie("username", cookies);
        if (iWantCookie != null) {
            resp.getWriter().println("找到了需要的cookie");
        }
    }

    protected void createCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决post请求中文乱码问题
        req.setCharacterEncoding("UTF-8");
        //解决中文乱码问题
        resp.setContentType("text/html;charset=UTF-8");
        //1.创建cookie对象
        Cookie cookie = new Cookie("username", "Tom");
        //2.通知客户端保存cookie
        resp.addCookie(cookie);
        //1.创建cookie对象
        Cookie cookie1 = new Cookie("key1", "value1");
        //2.通知客户端保存cookie
        resp.addCookie(cookie1);
        //1.创建cookie对象
        Cookie cookie2 = new Cookie("key2", "value2");
        //2.通知客户端保存cookie
        resp.addCookie(cookie2);

        resp.getWriter().println("cookie创建成功");
    }

    /**
     * 创建默认的存活时间的cookie
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("defaultLife", "defaultLife");
        //设置默认存活时间
        cookie.setMaxAge(-1);
        resp.addCookie(cookie);
        resp.getWriter().write("设置Cookie默认存活时间<br/>");
    }

    /**
     * 删除指定的cookie
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //先找到要删除的cookie对象
        Cookie cookie = CookieUtils.findCookie("key1", req.getCookies());
        //调用setMaxAge(0)
        if (cookie != null){
            cookie.setMaxAge(0);
            //调用resp.addCookie(cookie)
            resp.addCookie(cookie);
            resp.getWriter().write("key1的cookie已经被删除<br/>");
        }
    }

    /**
     * 设置cookie的存活时间
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void setCookieLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       Cookie cookie = new Cookie("life3600","life3600");
       cookie.setMaxAge(3600);
       resp.addCookie(cookie);
       resp.getWriter().write("设置cookie的存活时间为一小时");
    }

    /**
     * 设置cookie的路径
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void testPath(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       Cookie cookie = new Cookie("path1","path1");
       //req.getContextPath():获取工程路径
       cookie.setPath(req.getContextPath() + "/abc"); //工程路径/abc
       resp.addCookie(cookie);
       resp.getWriter().write("创建了一个带有路径的cookie对象");
    }

}