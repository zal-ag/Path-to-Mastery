package com.Silas.API.collection;

import java.util.HashMap;
import java.util.Map;

public class HashMapStudentLookupDemo {
    static void main() {
        Map<String,String> students = new HashMap<>();
        students.put("1001","张三");
        students.put("1002","李四");
        students.put("1003","张三");
        System.out.println(students.size()); // 3
        System.out.println(students.get("1002")); // 李四
        System.out.println(students.put("1002","王五")); // 李四
        System.out.println(students.get("1002")); // 王五
        System.out.println(students.size()); // 3
        System.out.println(students.get("9999")); // null
        System.out.println(students.containsKey("9999")); // false
        int count = 0;
        for(Map.Entry<String,String> entry : students.entrySet()){
            String id = entry.getKey();
            String name = entry.getValue();
            if("张三".equals(name)) count++;
            System.out.println(id+":"+name);
        }
        System.out.printf("姓名为张三的有%d个人",count);
    }
}
