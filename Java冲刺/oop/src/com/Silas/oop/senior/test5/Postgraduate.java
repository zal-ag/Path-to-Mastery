package com.Silas.oop.senior.test5;

public class Postgraduate extends Student{
    public Postgraduate() {
    }

    public Postgraduate(String name, int age, String grade) {
        super(name, age, grade);
    }
    public void study(){
        System.out.println("攻读硕士学位——");
    }
    public void sleep(){
        System.out.println("在豪华学生公寓睡觉——");
    }
}
