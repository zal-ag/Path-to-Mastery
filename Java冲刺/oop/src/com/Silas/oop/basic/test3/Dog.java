package com.Silas.oop.basic.test3;

public class Dog {
    private String name;
    private int age;

    public void setName(String value){
        name = value;
    }
    public String getName(){
        return name;
    }
    public void setAge(int num){
        if(num >= 0 && num <= 15){
            age = num;
        }else{
            System.out.printf("当前的age【%d】不在合理范围内",num);
        }
    }
    public int getAge(){
        return age;
    }

}
