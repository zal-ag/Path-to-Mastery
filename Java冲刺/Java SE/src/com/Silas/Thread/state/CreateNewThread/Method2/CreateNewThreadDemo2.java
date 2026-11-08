package com.Silas.Thread.state.CreateNewThread.Method2;

public class CreateNewThreadDemo2 {
    static void main(String[] args) {
        MyRunnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
