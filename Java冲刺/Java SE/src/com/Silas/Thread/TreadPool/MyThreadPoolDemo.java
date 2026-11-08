package com.Silas.Thread.TreadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyThreadPoolDemo {
    static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                3, // 核心线程数量
                6, // 最大线程数
                60, // 空闲线程最大存活时间
                TimeUnit.SECONDS, // 时间单位
                new ArrayBlockingQueue<>(3), // 任务队列
                Executors.defaultThreadFactory(), // 创建线程工程（从哪里获取线程）
                new ThreadPoolExecutor.AbortPolicy() // 任务的拒绝策略，超出最大线程数和任务队列的总和时，拒绝执行任务
        );
    }
}
