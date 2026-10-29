package com.silas.annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PracticeCheckRunner {
    static void main() throws InvocationTargetException, IllegalAccessException {
        StudentChecks stu = new StudentChecks();
        int count = 0;
        // 获取该类的声明方法，返回一个存储方法的数组
        Method[] methods = StudentChecks.class.getDeclaredMethods();
        for(Method method : methods){
            boolean marked = method.isAnnotationPresent(PracticeCheck.class);
            if(marked) {
                method.invoke(stu);
                count++;
            }
        }
        System.out.println("执行数量：" + count);
    }
}
