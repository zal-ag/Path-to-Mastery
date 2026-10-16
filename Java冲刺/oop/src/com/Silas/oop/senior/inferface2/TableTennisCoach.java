package com.Silas.oop.senior.inferface2;

public class TableTennisCoach extends Coach implements English{
    public TableTennisCoach() {
    }

    public TableTennisCoach(String name, int age) {
        super(name, age);
    }

    public void teach(){
        System.out.println("乒乓球教练教打乒乓球");
    }

    public void english(){
        System.out.println("乒乓球教练学习英语");
    }
}
