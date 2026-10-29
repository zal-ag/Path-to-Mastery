package com.silas.reflection;

import com.silas.student.StudentParser;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionExceptionDemo {
    static void main() throws ReflectiveOperationException{
        Method method = StudentParser.class.getMethod("parse",String.class);
        try{
            method.invoke(null,"1001,张三,abc,北京");
        } catch (InvocationTargetException e) {
            // 被包装后的异常
            System.out.println("外层异常：" + e.getClass().getSimpleName());
            // 内部真正的异常
            Throwable cause = e.getCause();
            System.out.println("原始异常：" + cause.getClass().getSimpleName());
            System.out.println("异常消息：" + cause.getMessage());
        }
    }
}
