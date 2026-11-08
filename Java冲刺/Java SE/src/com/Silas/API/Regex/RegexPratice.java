package com.Silas.API.Regex;

public class RegexPratice {
    public static boolean isValidStudentId(String id){
        if(id==null) return false;
        String regex = "S\\d{4}";
        return id.matches(regex);
    }
    public static boolean isValidUsername(String username){
        if(username == null) return false;
        String regex1 = "\\w{3,15}";
        String regex2 = "[0-9_]+";
        return username.matches(regex1) && !username.matches(regex2);
    }
    static void main() {
        // 方法1验证
        Student s1 = new Student("S1024");
        Student s2 = new Student();
        System.out.println(isValidStudentId(s1.getId()));
        System.out.println(isValidStudentId(s2.getId()));
        System.out.println(isValidStudentId("S12A4"));
        // 方法2验证
        System.out.println(isValidUsername("ab"));
        System.out.println(isValidUsername("Silas_123"));
        System.out.println(isValidUsername("12345__6"));
        System.out.println(isValidUsername("abcxvbnmfghdfghjk"));
        System.out.println(isValidUsername("______"));
        System.out.println(isValidUsername("张三123"));


    }
}
