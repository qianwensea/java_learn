package com.shi.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 千文sea
 * @create 2020-09-27 15:11
 *
 * 自定义拦截器
 */
public class MyInterceptor1 implements HandlerInterceptor {
    /**
     * 预处理,controller方法执行前
     * @param request
     * @param response
     * @param handler
     * @return true:表示放行,执行下一个拦截器,如果没有,执行controller中的方法.   false:不放行
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("MyInterceptor1执行了...前");
        return true;
    }

    /**
     * 后处理的方法, controller方法执行之后,success.jsp执行之前
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("MyInterceptor1执行了...后");
    }

    /**
     * success.jsp执行后执行
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("MyInterceptor1执行了...最后");
    }
}
