package com.shi.java1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author 千文sea
 * @create 2020-04-03 19:37
 */
public class PropertiesTest {
    //Properties: 常用来处理配置文件,key 和 value都是String类型的
    public static void main(String[] args) throws IOException {
        FileInputStream file = null;
        try {
            Properties pro = new Properties();
            file = new FileInputStream("jdbc.properties");
            pro.load(file);
            String name = pro.getProperty("name");
            String password = pro.getProperty("password");
            System.out.println("name:" + name + ",passw:" + password);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(file != null){
                try {
                    file.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
