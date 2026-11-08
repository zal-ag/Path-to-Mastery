package com.Silas.NetworkProgramming;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class BasicMethod {
    static void main(String[] args) throws UnknownHostException {

        // 根据 IP 字符串获取地址
        InetAddress host = InetAddress.getByName("127.0.0.1");
        System.out.println(host);

        // 根据 主机名 获取地址
        InetAddress address = InetAddress.getByName("DESKTOP-7T0LAS4");
        System.out.println(address);

        // 根据 本机主机名 获取地址
        System.out.println(InetAddress.getLocalHost());

        // 根据对象获取 对象 IP 地址
        System.out.println(address.getHostAddress());
        // 根据对象获取 对象主机名
        System.out.println(address.getHostName());
    }
}
