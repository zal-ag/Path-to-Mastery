package com.Silas.oop.basic.test6;

public class Test {
    static void main() {
        Student s = new Student();
        System.out.println(s.getName());
        System.out.println(s.getAge());
        System.out.println(s.getHeight());
        System.out.println(s.getWeight());

        Student ss = new Student("Silas",18,174,62);
        System.out.println(ss.getName());
        System.out.println(ss.getAge());
        System.out.println(ss.getHeight());
        System.out.println(ss.getWeight());
    }

}
