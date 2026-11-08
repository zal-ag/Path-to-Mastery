package com.Silas.Thread.ComprehensiveExercise.DrawTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class LotteryBox implements Runnable{

    Random random = new Random();
    ArrayList<Integer> prizePool = new ArrayList<>(Arrays.asList(10, 2, 20, 50, 100, 200, 500, 800, 2, 80, 300, 7000));


    public void run() {
        while (true) {
            if (prizePool.isEmpty()) {
                break;
            } else {
                int number = random.nextInt(prizePool.size());
                int prize = prizePool.remove(number);
                System.out.println(Thread.currentThread().getName() + "抽到了" + prize + "元大奖");
            }
        }
    }
}
