package com.Silas.Thread.state.CreateNewThread.Test1;

public class Consumer1 extends Thread {

    private int count = 0;

    @Override
    public void run() {
        while (true) {
            count++;
            int ticketNumber = 10;
            if(count > ticketNumber) break;
            System.out.println(Thread.currentThread().getName()+"拿到了第"+count+"张票");
        }
    }
}
