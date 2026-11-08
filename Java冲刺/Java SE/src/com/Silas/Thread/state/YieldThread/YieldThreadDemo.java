package com.Silas.Thread.state.YieldThread;

public class YieldThreadDemo {
    static void main() {
        MyThread runnable = new MyThread();
        new Thread(runnable,"A").start();
        new Thread(runnable,"B").start();

    }
}
