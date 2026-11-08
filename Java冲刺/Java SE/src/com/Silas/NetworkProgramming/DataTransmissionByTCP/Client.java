package com.Silas.NetworkProgramming.DataTransmissionByTCP;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    static void main(String[] args) throws IOException {

        // 创建一个套接字，尝试连接本机的10086端口
        Socket socket = new Socket("127.0.0.1",10086);

        // 获取发送数据的字节输出流
        OutputStream os = socket.getOutputStream();
        // 写入数据
        os.write("Silas,Good morning!".getBytes());

        // 释放资源
        socket.close();
    }
}
