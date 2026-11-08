package com.Silas.oop.basic.test3;

public class Test {
    static void main() {
        Dog d = new Dog();
        d.setName("小白");
        d.setAge(2);
        System.out.printf("%s %d岁",d.getName(),d.getAge());
    }
}
