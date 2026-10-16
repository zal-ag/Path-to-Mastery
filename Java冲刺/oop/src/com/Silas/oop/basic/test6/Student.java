package com.Silas.oop.basic.test6;

public class Student {
    private String name;
    private int age;
    private int height;
    private int weight;

    public Student(){
        System.out.println("空参构造方法被调用了");
    }
    public Student(String name,int age,int height,int weight){
        System.out.println("带全部参数的构造方法被调用了");
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return age;
    }

    public void setHeight(int height){
        this.height = height;
    }
    public int getHeight(){
        return height;
    }

    public void setWeight(int weight){
        this.weight = weight;
    }
    public int getWeight(){
        return weight;
    }
}
