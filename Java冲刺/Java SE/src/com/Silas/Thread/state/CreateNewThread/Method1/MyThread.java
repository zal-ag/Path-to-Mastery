package com.Silas.Thread.state.CreateNewThread.Method1;

public class MyThread extends Thread{

    @Override
    public void run() {
        for (int i = 1; i <= 1000 ; i++) {
            System.out.printf("Silas,I miss you! (%d)\n",i);
        }
    }
}
