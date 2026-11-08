package com.Silas.NetworkProgramming.DataTransmissionByTCP;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    static void main() throws IOException {
        try (ServerSocket server = new ServerSocket(10086)) {
            System.out.println("服务端已启动，等待连接");

            try (Socket socket = server.accept()) {
                System.out.println("客户端已连接");

                InputStream in = socket.getInputStream();

                int b;
                while ((b = in.read()) != -1) {
                    System.out.print((char) b);
                }

                System.out.println();
                System.out.println("接收结束");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
