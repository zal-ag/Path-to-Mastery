package com.Silas.exception;

public class Exception01 {
    static void main() {
        int num1 = 10;
        int num2 = 0;
        try{
            int result = num1 / num2;
        }catch (Exception e){
            System.out.println("出现异常的原因："+e.getMessage());
        }
    }
}
