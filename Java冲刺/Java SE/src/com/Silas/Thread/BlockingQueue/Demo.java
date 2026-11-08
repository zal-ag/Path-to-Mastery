package com.Silas.Thread.BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

public class Demo {
    static void main(String[] args) {
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(5);
        new Producer("商家",queue).start();
        new Consumer("客户",queue).start();


    }
}
