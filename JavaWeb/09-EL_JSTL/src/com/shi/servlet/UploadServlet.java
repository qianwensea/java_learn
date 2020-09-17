package com.shi.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author 千文sea
 * @create 2020-04-23 15:39
 */
public class UploadServlet extends HttpServlet {
    /**
     * 用于处理上传的文件
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*System.out.println("文件上传过来了");
        ServletInputStream inputStream = req.getInputStream();
        byte[] buf = new byte[1024];
        int read = inputStream.read(buf);
        System.out.println(new String(buf,0,read));*/

        //1.首先判断上传的数据是否是多段数据(只有多段的数据,才是文件上传的)
        if (ServletFileUpload.isMultipartContent(req)){
            //创建FileItemFactory工厂实现类
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            //创建用于解析上传数据的工具类ServletFileUpload类
            ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);
            //解析上传的数据,得到每一个表单项fileitem
            try {
                List<FileItem> list = fileUpload.parseRequest(req);
                //循环判断,每一个表单项,是普通表单项还是上传的表单项
                for (FileItem fileItem:list) {
                    if (fileItem.isFormField()){
                        //普通表单项
                        System.out.println("表单项的name属性值: " + fileItem.getFieldName());
                        //参数utf-8,解决乱码问题
                        System.out.println("表单项的value属性值: " + fileItem.getString("UTF-8"));
                    }else {
                        //上传的文件
                        System.out.println("表单项的name属性值: " + fileItem.getFieldName());
                        System.out.println("上传的文件名: " + fileItem.getName());
                        try {
                            fileItem.write(new File("d:\\" + fileItem.getName()));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            } catch (FileUploadException e) {
                e.printStackTrace();
            }
        }
    }
}
