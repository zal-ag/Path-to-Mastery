package com.Silas.NetworkProgramming.DataTransmissionByUDP.multicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class SendMessage {
    static void main(String[] args) throws IOException {

        // 创建 DatagramSocket 对象
        MulticastSocket ms = new MulticastSocket();

        // 打包数据
        String message = "Silas,how are you";
        byte[] bytes = message.getBytes();
        InetAddress address = InetAddress.getByName("114.0.0.1");
        int port = 10086;

        DatagramPacket dp = new DatagramPacket(bytes,bytes.length,address,port);

        // 发送数据包
        ms.send(dp);

        // 释放资源
        ms.close();

    }
}
