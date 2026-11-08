package com.Silas.Thread.state.YieldThread;

public class MyThread implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"开始执行");
        Thread.yield();
        System.out.println(Thread.currentThread().getName()+"执行完毕");
    }
}
