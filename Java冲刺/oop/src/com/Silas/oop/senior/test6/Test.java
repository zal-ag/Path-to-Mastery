package com.Silas.oop.senior.test6;

public class Test {
    static void main() {
        Human h = new Human("Silas",19,"男");
        System.out.println(h.getName()+" "+h.getAge()+" "+h.getGender());

        Bicycle b = new Bicycle("喜来登",20);
        h.drive(b);

        Car c = new Car("奔驰",100);
        h.drive(c);
    }
}
