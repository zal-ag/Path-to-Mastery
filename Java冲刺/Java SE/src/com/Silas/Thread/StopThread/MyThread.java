package com.Silas.Thread.StopThread;

public class MyThread implements Runnable {

    private boolean flag = true;

    @Override
    public void run() {
        while(flag) {
            System.out.println("running——");
        }
    }

    public void stop() {
        this.flag = false;
    }
}
