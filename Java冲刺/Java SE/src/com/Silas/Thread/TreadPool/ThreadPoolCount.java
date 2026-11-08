package com.Silas.Thread.TreadPool;

public class ThreadPoolCount {
    static void main(String[] args) {
        int count = Runtime.getRuntime().availableProcessors(); // 为JVM分配的最大并行数为24
        System.out.println(count);
    }
}
