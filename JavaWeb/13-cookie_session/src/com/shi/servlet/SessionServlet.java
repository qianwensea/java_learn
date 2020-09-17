package com.shi.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 千文sea
 * @create 2020-04-28 17:54
 */
public class SessionServlet extends BaseServlet {

    protected void createOrGetSession(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建和获取session回话对象
        HttpSession session = req.getSession();
        //判断当前session会话是否是新创建的
        boolean aNew = session.isNew();
        //获取session的唯一标识 id
        String id = session.getId();

        resp.getWriter().write("得到的session,它的id是: " + id + "<br/>");
        resp.getWriter().write("得到的session,它是否是新创建的: " + aNew + "<br/>");
    }

    /**
     * 在session域中保存数据
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void setAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.setAttribute("key1", "value1");
        resp.getWriter().write("已经在session中保存了数据");
    }

    /**
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void getAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object key1 = req.getSession().getAttribute("key1");
        resp.getWriter().write("从session中获取key1的数据是: " + key1);
    }

    /**
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        //获取session的默认超时时长
        int maxInactiveInterval = session.getMaxInactiveInterval();
        resp.getWriter().write("Session的默认超时时长为: " + maxInactiveInterval + "秒"); //30分钟
    }

    /**
     * 设置session超时时长
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void setLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        //设置session的超时时长(负数表示永不超时)
        session.setMaxInactiveInterval(3);
        resp.getWriter().write("当前Session的超时时长为: 3秒");
    }

    /**
     * 摧毁session
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 先获取 Session 对象
        HttpSession session = req.getSession();
        // 让 Session 会话马上超时
        session.invalidate();
        resp.getWriter().write("Session 已经设置为超时（无效）");
    }

}
