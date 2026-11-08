package com.Silas.NetworkProgramming.DataTransmissionByUDP.broadcast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class SendMessage {
    static void main(String[] args) throws IOException {

        // 创建 DatagramSocket 对象
        DatagramSocket ds = new DatagramSocket();

        // 打包数据
        String message = "Silas,how are you";
        byte[] bytes = message.getBytes();
        InetAddress address = InetAddress.getByName("127.0.0.1");
        int port = 10086;

        DatagramPacket dp = new DatagramPacket(bytes,bytes.length,address,port);

        // 发送数据包
        ds.send(dp);

        // 释放资源
        ds.close();

    }
}
