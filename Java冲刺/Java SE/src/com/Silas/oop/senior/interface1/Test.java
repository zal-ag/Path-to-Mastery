package com.Silas.oop.senior.interface1;

public class Test {
    static void main() {
        Frog f = new Frog("青蛙王子","绿色");
        System.out.println(f.getColor()+"的"+f.getName());
        f.eat();
        f.swim();
    }
}
