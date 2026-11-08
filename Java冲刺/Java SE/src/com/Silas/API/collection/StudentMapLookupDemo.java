package com.Silas.API.collection;

import com.Silas.StudentManagementSystem.Student;

import java.util.HashMap;
import java.util.Map;

public class StudentMapLookupDemo {
    static void main() {
        Map<String,Student> students = new HashMap<>();
        Student s1 = new Student("1001","张三",20,"北京");
        Student s2 = new Student("1002","李四",19,"上海");
        students.put(s1.getId(),s1);
        students.put(s2.getId(),s2);
        Student found = students.get("1002");
        if(found != null) System.out.println(found.getName()+" "+found.getAge()+" "+found.getAddress());
        if(students.get("9999") == null) System.out.println("该学号不存在");
        s2.setAge(21);
        Student again = students.get("1002");
        System.out.println(again.getAge());
    }
}
