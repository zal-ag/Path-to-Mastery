package com.Silas.API.String;

import java.util.Scanner;

public class RomanNumber {
    static void main() {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        String str;
        System.out.println("请输入全为数字的字符串");
        while (true) {
            str = sc.next();
            if (check(str)) break;
            else System.out.println("请重新输入");
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            sb.append(check(c - 48));
        }
        System.out.println(sb);
    }
    public static boolean check(String str){
        if(str.length() > 9) return false;
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(c < '0' || c > '9') return false;
        }
        return true;
    }
    public static String check(int num){
        String[] arr = {"","Ⅰ","Ⅱ","Ⅲ","Ⅳ","Ⅴ","Ⅵ","Ⅶ","Ⅷ","Ⅸ"};
        return arr[num];
    }

}
