package com.Silas.Thread.ThreadJoin;

public class Mythread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("我是VIP，你是什么");
        }
    }
}