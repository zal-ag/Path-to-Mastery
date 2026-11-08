package com.Silas.Thread.ThreadJoin;

public class ThreadJoinDemo {
    static void main() throws InterruptedException {

        Mythread runnable = new Mythread();
        Thread thread = new Thread(runnable);
        thread.start();

        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
            if(i == 20) thread.join();
        }
    }
}
