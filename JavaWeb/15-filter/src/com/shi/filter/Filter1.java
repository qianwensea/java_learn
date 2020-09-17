package com.shi.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author 千文sea
 * @create 2020-05-02 15:42
 */
public class Filter1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("前置代码1");
        System.out.println("Filter 1: " + servletRequest.getParameter("username"));
        System.out.println("Filter 1线程: " + Thread.currentThread().getName());
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("后置代码1");
    }
}
