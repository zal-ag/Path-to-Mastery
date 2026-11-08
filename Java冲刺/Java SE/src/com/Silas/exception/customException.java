package com.Silas.exception;

import java.util.Scanner;

public class customException {
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入年龄：");
        int age = sc.nextInt();
        if(age < 18 || age > 100){
            throw new AgeException("年龄需要在18-100之间");
        }
        System.out.println("年龄在符合范围内");
    }
}
class AgeException extends RuntimeException{
    public AgeException(String message) {
        super(message);
    }
}
