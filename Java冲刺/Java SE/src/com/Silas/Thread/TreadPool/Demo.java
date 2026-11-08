package com.Silas.Thread.TreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo {
    static void main() throws InterruptedException {
        ExecutorService pool = Executors.newCachedThreadPool();
        pool.submit(new MyRunnable());
        pool.submit(new MyRunnable());
        pool.submit(new MyRunnable());
        Thread.sleep(100);
        System.out.println("---");
        pool.submit(new MyRunnable());
          pool.submit(new MyRunnable());
        pool.shutdown();
    }
}
