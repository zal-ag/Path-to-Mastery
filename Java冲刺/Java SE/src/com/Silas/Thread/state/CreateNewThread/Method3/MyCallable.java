package com.Silas.Thread.state.CreateNewThread.Method3;

import java.util.concurrent.Callable;

public class MyCallable implements Callable {
    @Override
    public Callable<Void> call() {
        System.out.println("Silas,have a good day!");
        return null;
    }
}
