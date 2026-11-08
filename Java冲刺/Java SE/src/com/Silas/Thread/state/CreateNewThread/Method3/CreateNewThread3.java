package com.Silas.Thread.state.CreateNewThread.Method3;

import java.util.concurrent.*;

public class CreateNewThread3 {
    static void main(String[] args) {
        MyCallable thread = new MyCallable();

        try(ExecutorService service = Executors.newFixedThreadPool(1)) {
            Future future = service.submit(thread);
            future.get();
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
