package com.silas.reflection;

import com.silas.student.Student;
import com.silas.student.StudentValidator;

import java.lang.reflect.Field;

public class FieldAccessDemo {
    static void main() throws NoSuchFieldException, IllegalAccessException {
        Student stu = new Student("1001","张三",20,"北京");
        Field field = stu.getClass().getDeclaredField("name");
        try{
            System.out.println(field.get(stu));
        } catch (IllegalAccessException e) {
            System.out.println("直接读取被拒绝");
        }
        field.setAccessible(true);
        System.out.println(field.get(stu));

        Object value = field.get(stu);
        System.out.println(value);
        field.set(stu,"李四");
        Object name = field.get(stu);
        System.out.println(name);

        Field field1 = stu.getClass().getDeclaredField("age");
        field1.setAccessible(true);
        field1.set(stu,200);
        System.out.println(field1.get(stu));
        System.out.println(StudentValidator.isValidAge(stu.getAge()));


    }
}
