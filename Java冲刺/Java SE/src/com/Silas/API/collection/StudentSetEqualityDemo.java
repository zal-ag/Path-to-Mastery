package com.Silas.API.collection;

import com.Silas.StudentManagementSystem.Student;

import java.util.HashSet;
import java.util.Set;

public class StudentSetEqualityDemo {
    static void main() {
        Student a = new Student("1001", "张三", 20, "北京");
        Student b = new Student("1001", "张三", 20, "北京");
        System.out.println(a == b);
        System.out.println(a.equals(b));
        Set<Student> students = new HashSet<>();
        System.out.println(students.add(a));
        System.out.println(students.add(b));
        System.out.println(students.add(a));
        System.out.println(students.size());
    }
}
