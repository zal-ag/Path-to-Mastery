package com.Silas.oop.senior.inferface2;

public class BasketballPlayer extends Athlete{
    public BasketballPlayer() {
    }

    public BasketballPlayer(String name, int age) {
        super(name, age);
    }

    public void study(){
        System.out.println("篮球运动员学习打篮球");
    }
}
