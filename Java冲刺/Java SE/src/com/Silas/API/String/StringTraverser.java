package com.Silas.API.String;

import java.util.Scanner;

public class StringTraverser {
    static void main() {
        int smallCount = 0;
        int bigCount = 0;
        int numberCount = 0;

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String str = sc.next();
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(c >= 'a' && c <= 'z') smallCount++;
            else if(c >= 'A' && c <= 'Z') bigCount++;
            else if(c <= 9) numberCount++;
        }
        System.out.printf("小写字母：%d个%n大写字母：%d个%n数字：%d个",smallCount,bigCount,numberCount);

    }
}
