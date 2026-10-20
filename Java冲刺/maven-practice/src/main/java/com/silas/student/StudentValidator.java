package com.silas.student;

public class StudentValidator {
    public static boolean isValidAge(int age){
        return age >= 1 && age <= 120;
    }

    public static int parseAge(String text){
        if(text == null) throw new IllegalArgumentException("参数为空");
        int age = Integer.parseInt(text.strip());
        if(!isValidAge(age)) throw new IllegalArgumentException("年龄必须在1-120之间");
        return age;
    }
}
