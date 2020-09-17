package com.shi.java1;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 一.网络编程中有两个主要的问题：
 * 如何准确地定位网络上一台或多台主机；定位主机上的特定的应用
 * 找到主机后如何可靠高效地进行数据传输
 *
 * 二.网络编程中的两个要素
 * 1.IP和端口号
 * 2.网络通信协议: TCP/IP参考模型
 *
 * 三.通信要素一: IP和端口号
 * 1.IP: 唯一的标识 Internet 上的计算机（通信实体）
 * 2.在java中使用InetAddress类代表IP
 * 3.IP分类: IPV4 和 IPV6 ;万维网和局域网
 * 4.域名: www.baidu.com
 * 5.本地环回地址 : 127.0.0.1 对应着: localhost
 * 6.如何实例化InetAddress: 两个方法: getByname(String host) / getLocalHost()
 * 7.常用的两个方法: getHostName() / getHostAddress()
 * 8.端口号: 端口号标识正在计算机上运行的进程（程序）
 * 9.不同的进程有不同的端口号 ,被规定为一个 16 位的整数 0~65535。
 * 10. 端口号和IP组合得出一个套接字: socket
 * @author 千文sea
 * @create 2020-04-07 19:05
 */
public class InetAddressTest {

    public static void main(String[] args) {
        try {
            InetAddress byName = InetAddress.getByName("192.168.0.1");
            System.out.println(byName);

            InetAddress byName1 = InetAddress.getByName("www.baidu.com");
            System.out.println(byName1);

            InetAddress byName2 = InetAddress.getByName("127.0.0.1"); //本机地址
            //获取本机IP
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println(byName2);
            System.out.println(localHost);

            //getHostName()
            System.out.println(byName1.getHostName());
            //getHostAddress()
            System.out.println(byName1.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
