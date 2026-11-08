package com.Silas.oop.senior.interface1;

public class Dog extends Animal implements Swim{
    public Dog() {
    }

    public Dog(String name, String color) {
        super(name, color);
    }

    public void eat(){
        System.out.println("狗吃骨头");
    }
    public void swim(){
        System.out.println("狗刨式游泳");
    }
}
