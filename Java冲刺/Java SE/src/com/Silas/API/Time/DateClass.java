package com.Silas.API.Time;

import java.util.Date;
import java.util.Random;

public class DateClass {
    /*
        打印时间原点后一年的时间
     */
    private static void extracted(){
        Date origin = new Date(0L);
        System.out.println(origin);

        Long oneYear = 365L*24*60*60*1000;
        origin.setTime(oneYear);
        System.out.println(origin);

    }

    /*
        打印随机两个时间的时间差
     */
    private static void twoTimeDifference(){
        Random r = new Random();
        Date d1 = new Date(Math.abs(r.nextInt()));
        System.out.println(d1);
        Date d2 = new Date(Math.abs(r.nextInt()));
        System.out.println(d2);
        // 对象之间不能直接进行运算
        Long D1 = d1.getTime();
        Long D2 = d2.getTime();
        System.out.printf("d1和d2的时间差为%ds",Math.abs(D1-D2)/1000);

    }

    static void main() {
        // 获取当前时间
        Date d1 = new Date();
        System.out.println(d1);

        // 获取时间原点后指定时间，单位为ms
        Date d2 = new Date(0L);
        System.out.println(d2);

        // 设置时间
        d2.setTime(1000);
        System.out.println(d2);
        // 获取时间的毫秒值
        System.out.println(d2.getTime());

        extracted();
        twoTimeDifference();
    }
}
