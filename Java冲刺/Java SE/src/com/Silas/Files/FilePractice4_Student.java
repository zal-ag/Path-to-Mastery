package com.Silas.Files;

public class FilePractice4_Student {
    static void main() {
        String stuInfo = "1001,张三,20,北京";
        String[] stuArr = stuInfo.split(",");
        if(stuArr.length != 4) {
            System.out.println("记录格式错误");
            return;
        }
        try{
            int age = Integer.parseInt(stuArr[2]);
            if(age < 1 || age > 120) {
                System.out.println("年龄超出范围");
                return;
            }
            Student stu = new Student(stuArr[0],stuArr[1],age,stuArr[3]);
            System.out.println("学号：" + stu.getId());
            System.out.println("姓名：" + stu.getName());
            System.out.println("年龄：" + stu.getAge());
            System.out.println("地址：" + stu.getAddress());
        }catch (NumberFormatException e){
            System.out.println("格式错误：" + e.getMessage());
        }

    }
}
