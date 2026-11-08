package com.Silas.Thread.ComprehensiveExercise.DrawTest;

public class Demo {
    static void main(String[] args) {
        LotteryBox runnable = new LotteryBox();
        new Thread(runnable,"抽奖箱1").start();
        new Thread(runnable,"抽奖箱2").start();
    }


}