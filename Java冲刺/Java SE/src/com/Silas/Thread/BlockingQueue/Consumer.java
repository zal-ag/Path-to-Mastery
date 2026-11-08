package com.Silas.Thread.BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

public class Consumer extends Thread{
    String name;
    ArrayBlockingQueue<String> queue;

    public Consumer(String name,ArrayBlockingQueue<String> queue) {
        this.name = name;
        this.queue = queue;
    }

    public void run() {
        while(true) {
            try {
                queue.take();
                System.out.println("购买产品");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
