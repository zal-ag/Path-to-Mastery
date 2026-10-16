package com.Silas.oop.senior.inferface2;

public class TableTennisPlayer extends Athlete implements English{
    public TableTennisPlayer() {
    }

    public TableTennisPlayer(String name, int age) {
        super(name, age);
    }

    public void study(){
        System.out.println("乒乓球运动员学习打乒乓球");
    }

    public void english(){
        System.out.println("乒乓球运动员学习英语");
    }
}
