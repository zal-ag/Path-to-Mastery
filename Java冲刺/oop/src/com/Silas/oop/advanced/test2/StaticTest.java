package com.Silas.oop.advanced.test2;

public class StaticTest {
    static void main() {
        Student stu1 = new Student();
        Student stu2 = new Student();
        stu1.name = "Silas";
        stu1.age = 19;
        stu2.name = "Lily";
        stu2.age = 18;
        Student.TeacherName = "Lisi";

        System.out.println(stu1.name+"同学，"+stu1.age+"岁，老师是"+Student.TeacherName);
        System.out.println(stu2.name+"同学，"+stu2.age+"岁，老师是"+Student.TeacherName);
    }
}
