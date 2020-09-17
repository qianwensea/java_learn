package com.shi.java1;

import org.junit.Test;

import java.io.IOException;
import java.net.*;

/**
 * UDP网络编程
 * 例子:
 *
 * @author 千文sea
 * @create 2020-04-07 21:03
 */
public class UDPTest {
    @Test
    public void send() throws IOException {
        DatagramSocket ds = new DatagramSocket();
        String str = "我是UDP方式发送的数据";
        byte[] bytes = str.getBytes();
        InetAddress localHost = InetAddress.getLocalHost();
        DatagramPacket packet = new DatagramPacket(bytes,0,bytes.length,localHost,8899);

        ds.send(packet);
        ds.close();
    }
    @Test
    public void receive() throws IOException {
        DatagramSocket ds = new DatagramSocket(8899);
        byte[] buff = new byte[100];
        DatagramPacket packet = new DatagramPacket(buff,0,buff.length);
        ds.receive(packet);
        System.out.println(new String(packet.getData(),packet.getLength()));
        ds.close();
    }
}
