package com.Silas.oop.senior.test7;

public class Dog extends Animal{

    public Dog() {
    }

    public Dog(String name, String color) {
        super(name, color);
    }

    @Override
    public void eat() {
        System.out.println("狗吃骨头");
    }
}
