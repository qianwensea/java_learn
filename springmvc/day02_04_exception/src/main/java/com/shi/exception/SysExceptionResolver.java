package com.shi.exception;

import com.shi.exception.SysException;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 千文sea
 * @create 2020-09-24 17:16
 * 异常处理器
 */
public class SysExceptionResolver implements HandlerExceptionResolver {
    /**
     * 处理异常业务逻辑
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @return
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        //获取到异常对象
        SysException exception = null;
        if (ex instanceof SysException){
            exception = (SysException)ex;
        }else {
            exception = new SysException("系统正在维护");
        }
        //创建modelandview对象
        ModelAndView mv = new ModelAndView();
        mv.addObject("errorMsg", exception.getMessage());
        mv.setViewName("error");
        return mv;
    }
}
