package com.shi.java1;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 实现TCP网络编程
 * 例题三:.从客户端发送文件给服务端，服务端保存到本地。并返回“发送成功”给
 * 客户端。并关闭相应的连接。
 *
 * @author 千文sea
 * @create 2020-04-07 20:43
 */
public class TCPTest3 {
    @Test
    public void client(){
        Socket socket = null;
        OutputStream os = null;
        FileInputStream fis = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"),8899);
            os = socket.getOutputStream();
            fis = new FileInputStream(new File("IU.jpg"));
            byte[] buff = new byte[1024];
            int len;
            while ((len = fis.read(buff)) != -1){
                os.write(buff,0,len);
            }
            //关闭数据的输出
            socket.shutdownOutput();
            //接受服务器端的数据,并输出
            is = socket.getInputStream();
            baos = new ByteArrayOutputStream();
            byte[] buff1 = new byte[1024];
            int len1;
            while ((len1 = is.read(buff1)) != -1){
                baos.write(buff1,0,len1);
            }
            System.out.println(baos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null)
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (baos != null)
                baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fis !=  null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (os != null)
                    os.close();
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

    @Test
    public void server(){
        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        FileOutputStream fos = null;
        OutputStream os = null;
        try {
            ss = new ServerSocket(8899);
            socket = ss.accept();
            is = socket.getInputStream();
            fos = new FileOutputStream(new File("C:\\Users\\千文sea\\Desktop\\IU1.jpg"));
            byte[] buff = new byte[32];
            int len;
            while ((len = is.read(buff)) != -1){
                fos.write(buff,0,len);
            }
            System.out.println("收到来自" + socket.getInetAddress().getHostAddress() + "的图片");
            //服务器端给予客户端反馈
            os = socket.getOutputStream();
            os.write("你好,我已经收到照片了".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (os != null)
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (is != null)
                    is.close();
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
                if (ss != null)
                    ss.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
