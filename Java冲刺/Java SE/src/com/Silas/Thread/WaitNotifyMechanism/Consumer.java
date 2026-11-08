package com.Silas.Thread.WaitNotifyMechanism;

public class Consumer extends Thread{

    private String name;

    public Consumer(String name) {
        this.name = name;
    }

    public void run() {
        while(true) {
            synchronized (Middleware.lock) {
                if(Middleware.count <= 0 ) {
                    break;
                } else {
                    if(Middleware.flag == 0 ) {
                        try {
                            Middleware.lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        Middleware.count--;
                        System.out.println(name+"购买柜台上产品，库存还剩"+Middleware.count+"个");
                        Middleware.flag = 0;
                        Middleware.lock.notify();
                    }
                }
            }
        }
    }
}
