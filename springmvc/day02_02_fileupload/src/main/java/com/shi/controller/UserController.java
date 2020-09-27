package com.shi.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.org.apache.xpath.internal.operations.Mult;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

/**
 * @author 千文sea
 * @create 2020-09-24 15:35
 */
@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 跨服务器的文件上传
     * @return
     */
    @RequestMapping("testFileupload3")
    public String fileupload3(MultipartFile upload) throws Exception{

        System.out.println("跨服务器文件上传...");

        //定义上传文件服务器路径
        String path = "http://localhost:9090/day02_03_fileuploadserver/uploads/";

        //获取到上传文件的名称
        String fileItemName = upload.getOriginalFilename();
        //把文件名设置为唯一值
        String uuid = UUID.randomUUID().toString().replace("-", "");
        fileItemName = uuid + "_" + fileItemName;
        //完成文件跨服务器上传
            //创建客户端对象
        Client client = Client.create();
        //和图片服务器连接
        WebResource webResource = client.resource(path + fileItemName);
        webResource.put(upload.getBytes());
        return "success";
    }


    /**
     * springmvc 的文件上传
     * @return
     */
    @RequestMapping("testFileupload2")
   public String fileupload2(HttpServletRequest request, MultipartFile upload) throws Exception{

        System.out.println("SpringMVC文件上传...");

        //使用fileupload组件完成文件上传
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        //判断该路径是否存在
        File file = new File(path);
        if (!file.exists())
        {
            //创建文件夹
            file.mkdirs();
        }
        //获取到上传文件的名称
        String fileItemName = upload.getOriginalFilename();
        //把文件名设置为唯一值
        String uuid = UUID.randomUUID().toString().replace("-", "");
        fileItemName = uuid + "_" + fileItemName;
        //完成文件上传
        upload.transferTo(new File(path,fileItemName));
        return "success";
    }

    /**
     * 文件上传示例1
     * @return
     */
    @RequestMapping("/testFileupload1")
    public String fileupload1(HttpServletRequest request) throws Exception {
        System.out.println("文件上传...");

        //使用fileupload组件完成文件上传
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        //判断该路径是否存在
        File file = new File(path);
        if (!file.exists())
        {
            //创建文件夹
            file.mkdirs();
        }
        //解析request对象,获取文件上传项
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        //解析request
        List<FileItem> fileItems = upload.parseRequest(request);
        //遍历
        for (FileItem fileItem : fileItems){
            //进行判断,当前item对象是否为上传文件项
            if (fileItem.isFormField()){
                //说明是普通表单项

            }else {
                //说明是上传文件项
                //获取到上传文件的名称
                String fileItemName = fileItem.getName();
                System.out.println(path);
                System.out.println(fileItemName);
                //把文件名设置为唯一值
                String uuid = UUID.randomUUID().toString().replace("-", "");
                fileItemName = uuid + "_" + fileItemName;
                //完成文件上传
                fileItem.write(new File(path,fileItemName));
                //删除临时文件
                fileItem.delete();
            }
        }
        return "success";
    }
}
