package com.Silas.oop.senior.test7;

public class Cat extends Animal{
    public Cat() {
    }

    public Cat(String name, String color) {
        super(name, color);
    }

    @Override
    public void eat() {
        System.out.println("猫吃鱼");
    }

}
