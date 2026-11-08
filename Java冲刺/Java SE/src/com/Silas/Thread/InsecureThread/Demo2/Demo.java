package com.Silas.Thread.InsecureThread.Demo2;

public class Demo {
    static void main() {
        Account account = new Account("结婚基金",1000);
        Consumer you = new Consumer("you",account,50);
        Consumer she = new Consumer("she",account,100);
        you.start();
        she.start();
    }
}
