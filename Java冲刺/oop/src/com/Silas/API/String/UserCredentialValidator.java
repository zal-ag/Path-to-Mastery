package com.Silas.API.String;

import java.util.Scanner;

public class UserCredentialValidator {
    static void main() {
        final int MAX_COUNT = 3;
        String CORRECT_USERNAME = "Silas";
        String CORRECT_PASSWORD = "DemoOnly_123!"; // 仅用于练习的公开演示口令

        Scanner sc = new Scanner(System.in);
        int count = 0;
        while(count<3){
            System.out.println("请输入用户名字");
            String username = sc.next();
            if(username.equals(CORRECT_USERNAME)){
                System.out.println("请输入用户密码");
                String password = sc.next();
                if(password.equals(CORRECT_PASSWORD)){
                    break;
                }else{
                    count++;
                    System.out.printf("密码输入错误！您还剩%d次机会%n",MAX_COUNT-count);
                }
            }else{
                count++;
                System.out.printf("用户名输入错误！您还剩%d次机会%n",MAX_COUNT-count);
            }
        }
        if(count==3){
            System.out.println("失败次数过多，请稍后再试");
        }else{
            System.out.println("登录成功");
        }


    }
}
