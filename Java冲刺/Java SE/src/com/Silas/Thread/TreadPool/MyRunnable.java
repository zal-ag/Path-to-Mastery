package com.Silas.Thread.TreadPool;

public class MyRunnable implements Runnable {
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() +" | "+ i);
        }
    }
}
