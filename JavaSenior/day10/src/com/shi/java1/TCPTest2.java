package com.shi.java1;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP网络编程
 * 例题二: 客户端发送文件给服务端，服务端将文件保存在本地。
 *
 * @author 千文sea
 * @create 2020-04-07 20:29
 */
public class TCPTest2 {
    @Test
    public void client(){
        Socket socket = null;
        OutputStream os = null;
        FileInputStream fis = null;
        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"),8899);
            os = socket.getOutputStream();
            fis = new FileInputStream(new File("IU.jpg"));
            byte[] buff = new byte[1024];
            int len;
            while ((len = fis.read(buff)) != -1){
                os.write(buff,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

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
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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
