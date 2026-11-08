package com.Silas.NetworkProgramming.DataTransmissionByUDP.unicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ReceiveMessage {
    static void main(String[] args) throws IOException {

        // 创建 DatagramSocket 对象，需要绑定端口
        DatagramSocket ds = new DatagramSocket(10086);

        // 接收数据
        byte[] bytes = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bytes,bytes.length);
        ds.receive(dp);

        // 将 dp 里的 bytes数组 拿出来（解析数据包）
        byte[] data = dp.getData();
        int len = dp.getLength();

        // 接收端的操作系统收到这个网络包后，JDK 的底层代码（Native 方法）会解析这个网络包，
        // 把发送端的地址覆盖到你接收端 new 出来的那个 dp 对象的 address 和 port 字段上。
        InetAddress address = dp.getAddress();
        int port = dp.getPort();
        System.out.println("接收到数据："+new String(data,0,len));
        System.out.println("接收到数据来自"+address+"的"+port+"端口");


        // 释放资源
        ds.close();

    }
}
