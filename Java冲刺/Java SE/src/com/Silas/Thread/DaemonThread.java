package com.Silas.Thread;

public class DaemonThread {
    static void main() {

        Runnable human = () -> {
            for (int i = 0; i < 36500; i++) {
                System.out.println("living");
            }
            System.out.println("===Goodbye===");
        };

        Runnable god = () -> {
            while (true) {
                System.out.println("god bless you!");
            }
        };

        Thread threadGod = new Thread(god);
        threadGod.setDaemon(true);
        threadGod.start();

        Thread threadHuman = new Thread(human);
        threadHuman.start();

    }


}
