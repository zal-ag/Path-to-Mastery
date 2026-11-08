package com.Silas.Thread.InsecureThread.Demo1;

public class Consumer implements Runnable{
    private int count = 0;
    private boolean flag = true;

    public void run() {
        while (flag) {
            try {
                buy();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public synchronized void buy() throws InterruptedException {
        int ticket = 10;
        if(count >= ticket) {
            flag = false;
            return;
        }
        Thread.sleep(50);
        count++;
        System.out.println(Thread.currentThread().getName()+"买到了第"+count+"张票");
        Thread.yield();
    }
}
