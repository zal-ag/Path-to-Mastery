package com.Silas.API.String;

public class ReverseString {
    public static String reverse(String str){
        String result = "";
        for(int i=str.length()-1; i >= 0; i-- ){
            result += str.charAt(i);
        }
        return result;
    }

    static void main() {
        String str = "abcdefg";
        System.out.println(reverse(str));
    }

}
