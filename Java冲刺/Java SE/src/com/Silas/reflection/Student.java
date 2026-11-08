package com.Silas.reflection;

public class Student {
    public String name;
    public int age;
    private String address;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public Student(int age) {
        this.age = age;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private Student(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String eat(String food) {
        System.out.println("我正在吃"+food);
        return "alg";
    }

    private void showing() {
        System.out.println("我在洗澡");
    }
}
