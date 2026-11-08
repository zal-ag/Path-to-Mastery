package com.Silas.reflection;

import java.lang.reflect.Field;

public class FieldDemo {
    static void main() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        Class<?> type = Class.forName("com.Silas.reflection.Student");

        // 获取所有的 public 成员变量
        Field[] fields1 = type.getFields();
        for (Field field : fields1) {
            System.out.println(field);
        }

        System.out.println();

        // 获取所有的成员变量
        Field[] fields2 = type.getDeclaredFields();
        for (Field field : fields1) {
            System.out.println(field);
        }

        System.out.println();

        // 获取指定的 public 成员变量
        Field studentAge = type.getField("age");
        System.out.println(studentAge);

        System.out.println();

        // 获取指定的 任一成员变量
        Field studentAddress = type.getDeclaredField("address");
        System.out.println(studentAddress);

        System.out.println();

        // 获取权限修饰符
        int modifiers = studentAddress.getModifiers();
        System.out.println(modifiers); // private -> 2

        System.out.println();

        // 获取成员变量名称
        String str = studentAddress.getName();
        System.out.println(str);

        System.out.println();

        // 获取成员变量数据类型
        Class<?> types = studentAddress.getType();
        System.out.println(types);

        System.out.println();

        // 获取成员变量对应值
        Student stu = new Student("张三",22);
        stu.setAddress("xxx");

        Object valueAge = studentAge.get(stu);
        System.out.println(valueAge);

        // private 变量无法直接获取，需设置临时访问权限
        studentAddress.setAccessible(true);
        String valueAddress = (String) studentAddress.get(stu);
        System.out.println(valueAddress);

        System.out.println();

        // 修改成员变量的值
        studentAge.set(stu,100);
        System.out.println(stu.age);


    }


}
