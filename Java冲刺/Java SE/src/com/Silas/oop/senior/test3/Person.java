package com.Silas.oop.senior.test3;

public class Person {
    String name;
    int age;

    public Person() {
        System.out.println("父类Person的空参构造执行了");
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("父类Person的带参构造执行了");
    }
}
