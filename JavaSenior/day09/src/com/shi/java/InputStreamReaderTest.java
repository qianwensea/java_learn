package com.shi.java;

import org.junit.Test;

import java.io.*;

/**
 * 处理流之二: 转换流的使用
 * 1.转换流: 属于字符流
 *      InputStreamReader : 将一个字节的输入流转换为字符的输入流
 *      OutputStreamWriter : 将一个字符的输出流转换为字节的输出流
 *
 * 2.作用: 提供字节流与字符流之间的转换
 *
 * 3. 解码: 字节/字节数组 ---> 字符/字符数组
 *    编码: 字符数组/字符串 ---> 字节/字节数组
 *
 * 4.字符集
 *常见的编码表
 *  ASCII：美国标准信息交换码。
 *  用一个字节的7位可以表示。
 *  ISO8859-1：拉丁码表。欧洲码表
 *  用一个字节的8位表示。
 *  GB2312：中国的中文编码表。最多两个字节编码所有字符
 *  GBK：中国的中文编码表升级，融合了更多的中文文字符号。最多两个字节编码
 *  Unicode：国际标准码，融合了目前人类使用的所有字符。为每个字符分配唯一的字符码。所有的文字都用两个字节来表示。
 *  UTF-8：变长的编码方式，可用1-4个字节来表示一个字符。
 *
 * @author 千文sea
 * @create 2020-04-06 19:50
 */
public class InputStreamReaderTest {
    /*
    实现字节的输入流到字符的输入流
     */
    @Test
    public void test1(){
        InputStreamReader isr = null;
        try {
            FileInputStream fis = new FileInputStream("dbcp.txt");
//        InputStreamReader isr = new InputStreamReader(fis);//使用系统默认的字符集
            //参数2指明了字符集,具体使用那个字符集,取决于文件dbcp.txt保存时使用的字符集
            isr = new InputStreamReader(fis,"UTF-8");
            char[] cbuf = new char[20];
            int len;
            while ((len = isr.read(cbuf)) != -1){
                String str = new String(cbuf,0,len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (isr != null)
                isr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*
    综合使用InputStreamReader和OutputStreamWriter
    实现从"UTF-8" --> "GBK"
     */
    @Test
    public void test2(){
        InputStreamReader ips = null;
        OutputStreamWriter opw = null;
        try {
            //造文件
            File file1 = new File("dbcp.txt");
            File file2 = new File("dbcp_gbk.txt");
            FileInputStream fis = new FileInputStream(file1);
            FileOutputStream fos = new FileOutputStream(file2);
            ips = new InputStreamReader(fis,"utf-8");
            opw = new OutputStreamWriter(fos,"gbk");
            //读写过程
            char[] cbuf = new char[20];
            int len;
            while ((len = ips.read(cbuf)) != -1){
                opw.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (opw != null)
                opw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (ips != null)
                ips.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}