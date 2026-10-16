package com.Silas.exception;

import java.util.Scanner;

public class Exception02 {

    static void main() {
    /*
        输入一个整数，若不是整数，反复输入，直到输入整数为止
     */
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("请输入一个整数：");
            // 用字符串接受输入结果
            String str = sc.next();
            try {
                // 将字符串转为整数，不是整数抛出异常
                int num = Integer.parseInt(str);
                System.out.printf("你输入的整数为：%d",num);
                break;
            }catch(NumberFormatException e){
                System.out.println(e);
                System.out.println("你输入的不是整数，请重试");
            }
        }
        sc.close();
    }
}
