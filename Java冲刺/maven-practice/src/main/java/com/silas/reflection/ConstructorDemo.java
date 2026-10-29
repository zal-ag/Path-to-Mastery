package com.silas.reflection;

import com.silas.student.Student;

import java.lang.reflect.Constructor;

public class ConstructorDemo {
    static void main() throws ReflectiveOperationException {

        Class<Student> type = Student.class;

        // 找到空参构造方法
        Constructor<Student> constructor1 = type.getConstructor();
        Student stu1 = constructor1.newInstance();
        System.out.println(stu1.getAge());

        // 找到有参构造方法
        Constructor<Student> constructor2 = type.getConstructor(String.class,String.class,int.class,String.class);
        Student stu2 = constructor2.newInstance("1001","张三",20,"北京");
        System.out.println(stu2.getId());
        System.out.println(stu2.getName());
        System.out.println(stu2.getAge());
        System.out.println(stu2.getAddress());
    }
}
