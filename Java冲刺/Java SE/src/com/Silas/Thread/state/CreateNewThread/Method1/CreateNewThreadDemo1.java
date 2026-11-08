package com.Silas.Thread.state.CreateNewThread.Method1;

public class CreateNewThreadDemo1 {
    static void main(String[] args) {

        Thread thread = new MyThread();
        thread.start();

        for (int i = 1; i <=  1000; i++) {
            System.out.printf("Silas,I hate you! (%d)\n",i);
        }
    }
}
