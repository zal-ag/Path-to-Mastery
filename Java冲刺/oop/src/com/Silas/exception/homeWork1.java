package com.Silas.exception;

import com.sun.security.jgss.GSSUtil;

import java.util.Scanner;

public class homeWork1 {
    /*
        计算两数相除，需要对可能出现的异常进行处理
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = new String[2];
        System.out.println("num1");
        arr[0] = sc.next();
        System.out.println("num2");
        arr[1] = sc.next();

        try{
            int num1 = Integer.parseInt(arr[0]);
            int num2 = Integer.parseInt(arr[1]);

            double res = divide(num1,num2);
            System.out.println(res);
        }catch(NumberFormatException | ArithmeticException e){
            System.out.println(e.getMessage());
        } finally{
            sc.close();
        }
    }

    private static double divide(int num1,int num2) {
        return (double) num1 / num2;
    }

}
