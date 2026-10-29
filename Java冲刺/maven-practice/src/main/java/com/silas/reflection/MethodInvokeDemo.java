package com.silas.reflection;

import com.silas.student.Student;

import java.lang.reflect.Method;

import com.silas.student.StudentValidator;

public class MethodInvokeDemo {
    static void main() throws ReflectiveOperationException {
        // 创建对象
        Student stu = new Student("1001","张三",20,"北京");
        // 通过反射获取方法
        Method method1 = Student.class.getMethod("getName");
        Method method2 = stu.getClass().getMethod("getAge");
        // 通过反射调用方法
        Object name = method1.invoke(stu);
        int age = (int) method2.invoke(stu);
        // 验证结果
        System.out.println(name);
        System.out.println(age);

        // 通过反射调用含参方法，substring(int)：截取字符串（从指定索引到末尾）
        String text = "ABCDE";
        Method method3 = String.class.getMethod("substring",int.class);
        Object str = method3.invoke(text,2);
        System.out.println(str);

        // 通过反射调用静态方法
        Method method4 = StudentValidator.class.getMethod("isValidAge",int.class);
        Object x = method4.invoke(null,20);
        Object y = method4.invoke(null,0);
        Object z = method4.invoke(null,121);
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);

    }
}
