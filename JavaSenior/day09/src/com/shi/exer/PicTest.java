package com.shi.exer;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author 千文sea
 * @create 2020-04-06 19:36
 */
public class PicTest {
    //图片的加密
    @Test
    public void test1(){
//        FileInputStream fis = new FileInputStream(new File("tupian.jpg"));
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("tupian.jpg");
            fos = new FileOutputStream("tupianjiami.jpg");
            byte[] buff =  new byte[20];
            int len;
            while ((len = fis.read(buff)) != -1){
                //对字节数组进行修改
                for (int i = 0; i < len; i++) {
                    buff[i] ^= 5;
                }
                fos.write(buff,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null)
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fis != null)
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    //图片的解密
    @Test
    public void test2(){
//        FileInputStream fis = new FileInputStream(new File("tupian.jpg"));
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("tupianjiami.jpg");
            fos = new FileOutputStream("tupian4.jpg");
            byte[] buff =  new byte[20];
            int len;
            while ((len = fis.read(buff)) != -1){
                //对字节数组进行修改
                for (int i = 0; i < len; i++) {
                    buff[i] ^= 5;
                }
                fos.write(buff,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
