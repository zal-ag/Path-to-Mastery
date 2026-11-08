package com.Silas.Thread.WaitNotifyMechanism;

public class Main {
    static void main(String[] args) {
       new Producer("商家").start();
       new Consumer("客户1").start();
       new Consumer("客户2").start();
    }
}
