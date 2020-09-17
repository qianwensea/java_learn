package com.shi.mybatis.io;

import java.io.InputStream;

/**
 * @author 千文sea
 * @create 2020-09-13 15:54
 *
 * 使用类加载器读取配置文件
 */
public class Resources {
    /**
     * 根据传入的参数,获取一个字节输入流
     * @param filePath
     * @return
     */
    public static InputStream getResourceAsStream(String filePath){
        return Resources.class.getClassLoader().getResourceAsStream(filePath);
    }
}
