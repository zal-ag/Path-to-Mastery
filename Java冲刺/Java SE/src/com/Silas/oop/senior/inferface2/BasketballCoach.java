package com.Silas.oop.senior.inferface2;

public class BasketballCoach extends Coach{
    public BasketballCoach() {
    }

    public BasketballCoach(String name, int age) {
        super(name, age);
    }
    public void teach(){
        System.out.println("篮球教练教打篮球");
    }
}
