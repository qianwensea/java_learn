package com.shi.java;

import org.junit.Test;

import java.io.*;

/**
 * 处理流之一:缓冲流的使用
 *
 * 缓冲流(处理流的一种)
 * BufferedInputStream
 * BufferedOutputStream
 * BufferedReader
 * BufferedWriter
 *
 * 作用: 提高流的读取写入的速度
 *      原因: 内部提供了一个缓冲区
 *
 * 3. 处理流,就是"套接"在已有的流的基础上
 *
 * @author 千文sea
 * @create 2020-04-06 17:19
 */
public class BufferedTest {
    /*
    实现非文本文件的复制
     */
    @Test
    public void testBufferedStream() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bfis = null;
        BufferedOutputStream bfos = null;
        try {
            //1.造文件
            File srcFile = new File("tupian.jpg");
            File destFile = new File("tupian3.jpg");

            //2.造流
            //造节点流
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);
            //造缓冲流
            bfis = new BufferedInputStream(fis);
            bfos = new BufferedOutputStream(fos);

            //3.读,写数据
            byte[] buffer = new byte[5];
            int len;
            while((len = bfis.read(buffer)) != -1){
                bfos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭流资源
            //要求,先关闭外层的流在关闭内层的流
            try {
                if (bfis != null)
                     bfis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bfos != null)
                    bfos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //说明: 关闭外层流的同时,内层流同时也会关闭
//            fis.close();
//            fos.close();
        }
    }

    //实现文件复制的方法
    public void copyFilewithBuffer(String srcPath,String destpath){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bfis = null;
        BufferedOutputStream bfos = null;
        try {
            //1.造文件
            File srcFile = new File(srcPath);
            File destFile = new File(destpath);

            //2.造流
            //造节点流
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);
            //造缓冲流
            bfis = new BufferedInputStream(fis);
            bfos = new BufferedOutputStream(fos);

            //3.读,写数据
            byte[] buffer = new byte[1024];
            int len;
            while((len = bfis.read(buffer)) != -1){
                bfos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭流资源
            //要求,先关闭外层的流在关闭内层的流
            try {
                if (bfis != null)
                    bfis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bfos != null)
                    bfos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //说明: 关闭外层流的同时,内层流同时也会关闭
//            fis.close();
//            fos.close();
        }
    }
    //测试文件复制
    @Test
    public void testCopyFile(){
        long start = System.currentTimeMillis();
        copyFilewithBuffer("C:\\Users\\千文sea\\Desktop\\01.mp4","C:\\Users\\千文sea\\Desktop\\03.mp4");
//        copyFilewithBuffer("hello.txt","hello2.txt");
        long end = System.currentTimeMillis();
        System.out.println("复制完成,花费时间为: " + (end - start));
    }

    /*
    使用BufferedReader和BufferedWriter实现文本文件的复制
     */
    @Test
    public void testBufferedReaderWriter(){
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(new File("dbcp.txt")));
            bw = new BufferedWriter(new FileWriter(new File("dbcp1.txt")));
            //方式一: 使用char[]数组
//            char[] cbuf = new char[1024];
//            int len;
//            while ((len = br.read(cbuf)) != -1){
//                bw.write(cbuf,0,len);
//    //            bw.flush();
//            }
            //方式二: 使用string
            String str;
            while ((str = br.readLine()) != null){
                //方式二:
                bw.write(str);
                bw.newLine();
                //方式一:
//                bw.write(str + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null)
                    bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (br != null)
                    br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
