package com.shi.java;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 测试FileInputStream和FileOutputStream的使用
 *
 * 结论:
 * 1.对于文本文件(.txt,.java,.c),使用字符流处理
 * 2.对于非文本文件(.jpg,.MP3,.MP4...)使用字节流处理
 * 3.
 *
 * @author 千文sea
 * @create 2020-04-06 16:48
 */
public class FileInput_OutputStreamTest {
    /*
        使用字节流FileInputStream处理文本文件可能会出现乱码
     */
    @Test
    public void testFileInputStream() {
        FileInputStream fis = null;
        try {
            //1.创建File类的对象
            File file = new File("hello.txt");

            //2.造流
            fis = new FileInputStream(file);

            //3.读数据
            byte[] bytes = new byte[5];
            int len;
            while ((len = fis.read(bytes)) != -1){
                String str = new String(bytes,0,len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭流
            try {
                if (fis != null)
                     fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /*
    实现图片的复制操作
     */
    @Test
    public void testFileInputOutputStream(){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //1.创建File类对象
            File srcFile = new File("tupian.jpg");
            File destFile = new File("tupian1.jpg");
            //2.
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            //3.
            byte[] buffer = new byte[5];
            int len;
            while ((len = fis.read(buffer)) != -1){
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.
            try {
                if (fis != null)
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fos != null)
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //指定路径下文件的复制
    public void copyFile(String srcStr,String destStr){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //1.创建File类对象
            File srcFile = new File(srcStr);
            File destFile = new File(destStr);
            //2.
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            //3.
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1){
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @Test
    public void testCopyFile(){
        long start = System.currentTimeMillis();
        copyFile("C:\\Users\\千文sea\\Desktop\\01.mp4","C:\\Users\\千文sea\\Desktop\\02.mp4");
//        copyFile("hello.txt","hello2.txt");
        long end = System.currentTimeMillis();
        System.out.println("复制完成,花费时间为: " + (end - start)); //16939
    }
}
