package com.Silas.Thread.state;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadSleep {
    static void main(String[] args) {
        while (true) {
            try {
                Date startTime = new Date(System.currentTimeMillis());
                System.out.println(new SimpleDateFormat("HH:mm:ss").format(startTime));
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
