package com.Silas.oop.senior.interface1;

public class Frog extends Animal implements Swim{
    public Frog() {
    }

    public Frog(String name, String color) {
        super(name, color);
    }

    public void eat(){
        System.out.println("青蛙吃虫子");
    }

    public void swim(){
        System.out.println("蛙泳");
    }
}
