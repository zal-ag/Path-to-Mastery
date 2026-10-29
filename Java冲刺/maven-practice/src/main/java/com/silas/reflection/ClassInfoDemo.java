package com.silas.reflection;

import com.silas.student.Student;

public class ClassInfoDemo {
    static void main() throws ClassNotFoundException{
        // 获取 Student 类的 Class 对象
        Class<Student> type = Student.class;
        System.out.println(type.getName());
        System.out.println(type.getSimpleName());
        Class<Student> example = Student.class;
        System.out.println(type == example);

        Object obj = new Student();
        System.out.println(obj.getClass().getName());
        Class<?> x = Class.forName("com.silas.student.Student");
        System.out.println(obj.getClass() == type);
        System.out.println(x == type);
    }
}
