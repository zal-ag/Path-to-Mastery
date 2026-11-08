package com.Silas.Thread.InsecureThread;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class copyOnWriteArrayList {
    static void main(String[] args) throws InterruptedException {
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(
                    () -> list.add(Thread.currentThread().getName())
            ).start();
        }
        Thread.sleep(3000);
        System.out.println(list.size());
    }
}
