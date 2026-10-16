package com.Silas.oop.basic.test7;

public class Test {
    static void main() {
        Student stu1 = new Student();
        stu1.setName("Silas");
        stu1.setAge(19);
        System.out.println(stu1.getName());
        System.out.println(stu1.getAge());

        Student stu2 = new Student("Lily",18);
        System.out.println(stu2.getName());
        System.out.println(stu2.getAge());
    }

}
