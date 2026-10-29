package com.silas.reflection;

import com.silas.student.Student;

import java.lang.reflect.Field;

public class FieldInfoDemo {
    static void main() {
        // 获取 public 字段数组
        Field[] field0 = Student.class.getFields();
        System.out.println(field0.length);

        // 获取当前类声明的字段，不限访问修饰符
        Field[] fields = Student.class.getDeclaredFields();
        System.out.println(fields.length);
        for(Field field : fields){
            // 获取该字段的名称
            String fieldName = field.getName();
            // 获取该字段对应的类
            Class<?> fieldType =  field.getType();
            System.out.println(fieldType);
            System.out.println(fieldType.getName());
            // 获取类名
            String typeName = fieldType.getSimpleName();
            System.out.println(fieldName + "-" + typeName);
        }

    }
}
