package com.silas.annotation;

public class StudentChecks {

    @PracticeCheck
    public void checkAge() {
        System.out.println("检查年龄");
    }

    @PracticeCheck
    public void checkName() {
        System.out.println("检查姓名");
    }

    public void helper() {
        System.out.println("辅助方法");
    }
}
