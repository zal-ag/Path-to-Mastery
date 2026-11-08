package com.Silas.Thread.BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

public class Producer extends Thread{
    String name;
    ArrayBlockingQueue<String> queue;

    public Producer(String name,ArrayBlockingQueue<String> queue) {
        this.name = name;
        this.queue = queue;
    }

    public void run() {
        while(true) {
            try {
                queue.put("产品");
                System.out.println("产品上新");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
