package com.Silas.oop.senior.test5;

public class Undergraduate extends Student{
    public Undergraduate() {
    }

    public Undergraduate(String name, int age, String grade) {
        super(name, age, grade);
    }

    public void study(){
            System.out.println("攻读学士学位——");
    }
}
