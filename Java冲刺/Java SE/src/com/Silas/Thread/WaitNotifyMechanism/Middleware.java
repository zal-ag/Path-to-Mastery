package com.Silas.Thread.WaitNotifyMechanism;

public class Middleware {
    // 柜台
    public static int flag = 0;
    // 库存
    public static int count = 10;

    public static Object lock = new Object();
}
