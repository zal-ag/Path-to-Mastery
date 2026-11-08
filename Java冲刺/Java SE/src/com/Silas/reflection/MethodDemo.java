package com.Silas.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodDemo {
    static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> type = Class.forName("com.Silas.reflection.Student");

        Method[] methods1 = type.getMethods();
        for (Method method : methods1) {
            System.out.println(method);
        }
        System.out.println(methods1.length);

        System.out.println();

        Method[] methods2 = type.getDeclaredMethods();
        for (Method method : methods2) {
            System.out.println(method);
        }
        System.out.println(methods2.length);

        System.out.println();

        Student stu = new Student();
        Method method1 = type.getMethod("eat",String.class);
        Object result1 = method1.invoke(stu,"apple");
        System.out.println(result1);
        String result2 = (String) method1.invoke(stu,"banana");
        System.out.println(result2);

        System.out.println();

        Method method2 = type.getDeclaredMethod("showing");
        method2.setAccessible(true);
        method2.invoke(stu);


    }

}
