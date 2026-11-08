package com.Silas.Thread.StopThread;

public class StopThreadDemo {
    static void main(String[] args) throws InterruptedException {
        MyThread runnable = new MyThread();
        Thread thread = new Thread(runnable);
        thread.start();
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
            if(i == 900) {
                runnable.stop();
                System.out.println("线程该停止了");
            }
        }
    }
}
