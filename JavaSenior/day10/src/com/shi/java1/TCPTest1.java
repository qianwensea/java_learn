package com.shi.java1;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 实现TCP网络编程
 * 例子1: 客户端发送一段话给服务端,服务端输出到控制台
 *
 * @author 千文sea
 * @create 2020-04-07 20:07
 */
public class TCPTest1 {
    //客户端
    @Test
    public void client() {
        Socket socket = null;
        OutputStream outputStream = null;
        try {
            //1创建Socket对象,指明服务器的ip和端口号
            InetAddress inet = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inet,8899);
            //2.获取一个输出流,用于输出数据
            outputStream = socket.getOutputStream();
            //3.写出数据的操作
            outputStream.write("你好我是客户端".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源关闭
            try {
                if (outputStream != null)
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (socket != null)
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    //服务端
    @Test
    public void server(){
        ServerSocket ser = null;
        Socket socket = null;
        InputStream inputStream = null;
        ByteArrayOutputStream bos = null;
        try {
            //1.创建ServerSocket,指明自己的端口号
            ser = new ServerSocket(8899);
            //2.调用accept()表示接收客户端的socket
            socket = ser.accept();
            //3.获取输入流
            inputStream = socket.getInputStream();
            //不建议这样写,可能会出现乱码
//        byte[] buff = new byte[20];
//        int len;
//        while ((len = inputStream.read(buff)) != -1){
//            String str = new String(buff,0,len);
//            System.out.print(str);
//        }
            //正确写法
            //4.读取输入流的数据
            bos = new ByteArrayOutputStream();
            byte[] buff = new byte[5];
            int len;
            while ((len = inputStream.read(buff)) != -1){
                bos.write(buff,0,len);
            }
            System.out.println(bos.toString());
            System.out.println("收到了" + socket.getInetAddress().getHostAddress() + "的数据");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //5.关闭资源
            try {
                if (bos != null)
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (inputStream != null)
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (socket != null)
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (ser != null)
                ser.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
