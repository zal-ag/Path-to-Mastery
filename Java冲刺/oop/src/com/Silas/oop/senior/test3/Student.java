package com.Silas.oop.senior.test3;

public class Student extends Person{
    String grade;

    public Student() {
        System.out.println("子类Student的空参构造执行了");
    }

    public Student(String name, int age, String grade) {
        super(name, age);
        this.grade = grade;
        System.out.println("子类Student的带参构造执行了");
    }
}
