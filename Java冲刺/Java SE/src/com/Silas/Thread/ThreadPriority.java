package com.Silas.Thread;

public class ThreadPriority {
    static void main(String[] args) {

        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName()
                    + "-->" + Thread.currentThread().getPriority());
        };

        System.out.println(Thread.currentThread().getName()
                + "-->" + Thread.currentThread().getPriority());

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        Thread t3 = new Thread(runnable);
        Thread t4 = new Thread(runnable);
        Thread t5 = new Thread(runnable);
        Thread t6 = new Thread(runnable);

        t1.start();

        t2.setPriority(1);
        t2.start();

        t3.setPriority(4);
        t3.start();

        t4.setPriority(Thread.MAX_PRIORITY);
        t4.start();

        t5.setPriority(8);
        t5.start();

        t6.setPriority(7);
        t6.start();
    }
}
