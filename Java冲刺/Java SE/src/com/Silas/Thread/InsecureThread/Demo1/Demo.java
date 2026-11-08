package com.Silas.Thread.InsecureThread.Demo1;

public class Demo {
    static void main(String[] args) {
        Consumer consumer = new Consumer();
        new Thread(consumer,"甲").start();
        new Thread(consumer,"乙").start();
        new Thread(consumer,"丙").start();
    }
}
