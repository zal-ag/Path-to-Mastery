package com.Silas.Thread.InsecureThread.Demo2;

class Account {
    String name;
    int money;

    public Account(String name, int money) {
        this.name = name;
        this.money = money;
    }
}


public class Consumer extends Thread {


    Account account;
    int drawingMoney;
    int handMoney;

    public Consumer(String name, Account account, int drawingMoney) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    @Override
    public void run() {
        synchronized(account){
            if(account.money - drawingMoney < 0 ) {
                System.out.println(this.getName()+"余额不足");
                return;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            account.money = account.money - drawingMoney;
            handMoney = handMoney + drawingMoney;
            System.out.println(account.name+"余额："+account.money);
            System.out.println(this.getName()+"手里的钱："+handMoney);
        }
    }
}
