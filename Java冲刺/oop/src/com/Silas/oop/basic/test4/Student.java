package com.Silas.oop.basic.test4;

public class Student {
    private String name;
    private int age;
    private int height;
    private int weight;

    public void setName(String value){
        name = value;
    }
    public String getName(){
        return name;
    }
    public void setAge(int num){
        age = num;
    }
    public int getAge(){
        return age;
    }
    public void setHeight(int num){
        height = num;
    }
    public int getHeight(){
        return height;
    }
    public void setWeight(int num){
        weight = num;
    }
    public int getWeight(){
        return weight;
    }
    public void study(){
        System.out.println(name+"在努力学习");
    }

}
