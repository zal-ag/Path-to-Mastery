package com.Silas.API.generics;

import com.Silas.StudentManagementSystem.Student;

public class GenericBoxDemo {
    static void main() {
        Box<String> str = new Box<>("silas");
        Box<Integer> ints = new Box<>(19);
        Box<Student> student = new Box<>(new Student("1001","silas",19,"Beijing"));
        System.out.println(str.get());
        System.out.println(ints.get());
        System.out.println(student.get().getName());
        Box<String> str1 = new Box<>();
        System.out.println(str1.get());
    }

}
