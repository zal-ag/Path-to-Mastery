package com.Silas.Thread;

public class ThreadState {
    static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread( () -> {
            for (int i = 0; i < 5; i++) {
                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("/////");
        });

        // 观察状态
        Thread.State state = thread.getState();
        System.out.println(state);

        thread.start();
        state = thread.getState();
        System.out.println(state);

        while(state != Thread.State.TERMINATED) {
            Thread.sleep(50);
            state = thread.getState();
            System.out.println(state);
        }

    }

}
