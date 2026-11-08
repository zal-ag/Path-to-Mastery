package com.Silas.Thread.state.CreateNewThread.Test1;

public class TicketInstance {
    static void main(String[] args) {

        new Consumer1().start();
        new Consumer1().start();
        new Consumer1().start();

        try{
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("出现异常"+e.getMessage());
        }

        // 三个线程共享一个 Runnable 对象，可以共享实例字段，但方法里的局部变量仍然各自独立
        Consumer2 runnable = new Consumer2();
        new Thread(runnable,"One").start();
        new Thread(runnable,"Two").start();
        new Thread(runnable,"Three").start();
    }
}
