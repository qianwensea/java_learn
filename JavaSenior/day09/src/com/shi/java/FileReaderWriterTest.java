package com.shi.java;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 一.流的分类
 * 按操作数据单位不同分为：字节流(8 bit)，字符流(16 bit)
 * 按数据流的流向不同分为：输入流，输出流
 * 按流的角色的不同分为：节点流，处理流
 *
 * 二.流的体系结构
 * 抽象基类:                  节点流(或文件流)                                   缓冲流(处理流的一种)
 * InputStream:               FileInputStream (read(byte[] buf))               BufferedInputStream (read(byte[] buf))
 * OutputStream:              FileOutputStream (write(byte buf,0,len))         BufferedOutputStream (write(byte buf,0,len))/flush()
 * Reader                     FileReader (read(char[] cbuf))                   BufferedReader (read(char[] cbuf)) /readline()
 * Writer                     FileWriter (write(char cbuf,0,len))              BufferedWriter (write(char cbuf,0,len)) /flush()
 *
 *
 *
 * @author 千文sea
 * @create 2020-04-06 15:47
 */
public class FileReaderWriterTest {
    /*
    将day09下的hello.txt文件内容读入程序中,并输出到控制台

    说明:
    1. read()的理解: 返回读入的一个字符.如果达到文件末尾,则返回-1
    2. 异常的处理: 为了保证流资源一定可以执行关闭操作.需要使用try-catch- finally处理
    3. 读入的文件一定要存在,否则就会报FileNotFoundException
     */
    @Test
    public void testFileReader() {
        FileReader read = null;
        try {
            //1.实例化File类对象,指明要操作的对象
            File file = new File("hello.txt"); //相较于当前module
            //2.提供具体的流
            read = new FileReader(file);
            //3.数据的读入
            //read(): 返回读入的一个字符.如果达到文件末尾,返回-1
//        int read1 = read.read();
//        while (read1 != -1){
//            System.out.print((char) read1);
//            read1 = read.read();
//        }
            int data;
            while ((data = read.read()) != -1){
                System.out.println((char)data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.流的关闭操作
            try {
                if(read != null)
                     read.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //对read()操作的升级: 使用read()重载的方法
    @Test
    public void testFileReader1() {
        FileReader fr = null;
        try {
            //1.File类的实例化
            File file = new File("hello.txt");
            //2.FileReader流的实例化
            fr = new FileReader(file);
            //3.读入的操作
            //read(char[] cbuf): 返回每次读入cbuf数组中的字符的个数.如果达到文件末尾返回-1.
            char[] cbuf = new char[5];
            int len;
            while ((len = fr.read(cbuf)) != -1){
                //方式一:
//                for (int i = 0; i < len; i++) { //此处不能写cbuf.length
//                    System.out.print(cbuf[i]);
//                }
                //方式二:
                String str = new String(cbuf,0,len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源的关闭
            try {
                if (fr != null)
                     fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*
    从内存中写出数据到硬盘的文件里

    说明:
    1. 输出操作,对应的File文件可以不存在,并不会报异常
    2.
        File文件如果不存在,在输出过程中,会自动创建此文件
        File文件如果文件存在:
                如果流使用的构造器是: FileWriter(file,false)/FileWriter(file): 对原文件进行覆盖
                如果流使用的构造器是: FileWriter(file,true): 对原文件的末尾进行添加
     */
    @Test
    public void testFilewriter() {
        FileWriter fw = null;
        try {
            //1.提供File类的对象,指明要写出的文件
            File file = new File("hello1.txt");
            //2.提供FileWriter的对象,用于数据的写出
            fw = new FileWriter(file,false);

            //3.写出的操作
            fw.write("I hava a dream\n");
            fw.write("You need to have a dream");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.流资源的关闭
            try {
                if (fw != null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testFileReaderWriter() {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            //1.创建File类对象,指明读入和写出的文件
            File file1 = new File("hello.txt");
            File file2 = new File("hello1.txt");
            //2.创建输入流和输出流的对象,不能处理图片等字节文件
           fr = new FileReader(file1);
           fw = new FileWriter(file2);
            //3.数据的读入和写出
            char[] cbuf = new char[5];
            int len; //记录每次读入cbuf中的数据
            while ((len = fr.read(cbuf)) != -1){
                fw.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.流资源的关闭
            if (fr != null ){
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fw != null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
