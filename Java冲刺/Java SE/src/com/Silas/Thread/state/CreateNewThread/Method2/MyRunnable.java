package com.Silas.Thread.state.CreateNewThread.Method2;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("I miss you!");
        }
    }
}
