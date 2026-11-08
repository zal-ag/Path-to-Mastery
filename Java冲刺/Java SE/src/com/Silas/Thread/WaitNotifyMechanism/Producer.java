package com.Silas.Thread.WaitNotifyMechanism;

public class Producer extends Thread{

    private String name;

    public Producer(String name) {
        this.name = name;
    }

    public void run() {
        while(true) {
            synchronized (Middleware.lock) {
                if(Middleware.count <= 0 ) {
                    break;
                } else {
                    if(Middleware.flag == 0 ) {
                        System.out.println("柜台上新");
                        Middleware.flag = 1;
                        Middleware.lock.notifyAll();
                    } else {
                        try {
                            Middleware.lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }
    }
}
