package com.Silas.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ConstructorDemo {
    static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<Student> type = Student.class;

        // 获取所有 public 构造方法
        Constructor<?>[] set1 = type.getConstructors();
        for(Constructor<?> cons : set1) {
            System.out.println(cons);
        }

        System.out.println();

        // 获取所有构造方法
        Constructor<?>[] set2 = type.getDeclaredConstructors();
        for(Constructor<?> cons : set2) {
            System.out.println(cons);
        }

        System.out.println();

        // 获取指定 public 双参构造方法
        Constructor<Student> constructor1  = type.getConstructor(String.class,int.class);
        System.out.println(constructor1);
        Object stu = constructor1.newInstance("张三",21);
        System.out.println(constructor1.getName());

        System.out.println();

        // 获取指定 private 构造方法
        Constructor<Student> constructor2 = type.getDeclaredConstructor(String.class,int.class,String.class);
        System.out.println(constructor2);
        // 将该 private 方法设置为临时可用
        constructor2.setAccessible(true);
        Student stu2 = (Student) constructor2.newInstance("李四",22 ,"上海");

        System.out.println();

        // 获取方法的权限修饰符
        int modifiers1 = constructor1.getModifiers();
        System.out.println(modifiers1); // 1 为 public
        int modifiers2 = constructor2.getModifiers();
        System.out.println(modifiers2); // 2 为 private
    }
}
