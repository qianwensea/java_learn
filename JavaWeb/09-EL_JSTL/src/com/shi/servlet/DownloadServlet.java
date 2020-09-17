package com.shi.servlet;

import org.apache.commons.io.IOUtils;
import sun.misc.BASE64Encoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

/**
 * @author 千文sea
 * @create 2020-04-23 16:17
 */
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取要下载的文件名
        String downloadFileName = "3.jpg";
        //2.读取要下载的文件内容(通过ServletContext对象可以读取)
        ServletContext servletContext = getServletContext();

        //获取要下载的文件类型
        String mimeType = servletContext.getMimeType("/imgs//" + downloadFileName);
        System.out.println("下载的文件类型: " + mimeType);
        //4.在回传前,通过响应头告诉客户端返回的数据类型
        resp.setContentType(mimeType);

        //5.还要告诉客户端收到的数据是用于下载使用的(还是使用响应头)
        //Content-Disposition响应头:表示收到的数据怎么处理
        //attachment: 表示附件,表示下载使用
        //filename= 表示指定下载文件的文件名,可以自己定义

       /*
       *  *//*
        URLEncoder 解决 IE 和谷歌浏览器的 附件中问题。
         *//*
        // 把中文名进行 UTF-8 编码操作。
        String str = "attachment; fileName=" + URLEncoder.encode("中文.jpg", "UTF-8");
        // 然后把编码后的字符串设置到响应头中
        resp.setHeader("Content-Disposition", str);

        *//**
         * BASE64 编解码 解决 火狐浏览器的附件中文名问题
         *//*
        // 使用下面的格式进行 BASE64 编码后
        String str1 = "attachment; fileName=" + "=?utf-8?B?"
                + new BASE64Encoder().encode("中文.jpg".getBytes("utf-8")) + "?=";
        // 设置到响应头中
        resp.setHeader("Content-Disposition", str);
        */

        String ua = req.getHeader("User-Agent");
        // 判断是否是火狐浏览器
        if (ua.contains("Firefox")) {
        // 使用下面的格式进行 BASE64 编码后
            String str = "attachment; fileName=" + "=?utf-8?B?"
                    + new BASE64Encoder().encode("中文.jpg".getBytes("utf-8")) + "?=";
        // 设置到响应头中
            resp.setHeader("Content-Disposition", str);
        } else {
        // 把中文名进行 UTF-8 编码操作。
            String str = "attachment; fileName=" + URLEncoder.encode("中文.jpg", "UTF-8");
        // 然后把编码后的字符串设置到响应头中
            resp.setHeader("Content-Disposition", str);
        }


        /**
         * / 斜杠在服务器解析表示地址为http://ip地址:端口号/工程名/  映射到 代码的web目录
         */
        InputStream resourceAsStream = servletContext.getResourceAsStream("/imgs/" + downloadFileName);
        System.out.println(resourceAsStream.toString());
        //获取响应的输出流
        OutputStream outputStream = resp.getOutputStream();

        //3.把下载的文件内容回传给客户端
        //读取输入流中的全部数据,复制给输出流,回传给客户端
        IOUtils.copy(resourceAsStream,outputStream);
    }
}
