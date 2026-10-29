package com.silas.jdbc;

import com.silas.student.Student;

import java.sql.*;
import java.util.Scanner;

public class StudentByIdQueryDemo2 {
    static void main() {
        String url = "jdbc:mysql://127.0.0.1:3306/student_management";
        String username = "root";
        Scanner sc = new Scanner(System.in);
        System.out.printf("请输入%s用户密码\n",username);
        String password = sc.nextLine();
        try(Connection connection = DriverManager.getConnection(url,username,password)) {
            System.out.println("数据库连接成功");
            System.out.println("请输入要查询的学生ID");
            String id = sc.next();
            Student stu = StudentRepository.findById(connection,id);
            if(stu == null) {
                System.out.println("未找到该学生");
            } else {
                String address = stu.getAddress();
                if(address == null) address = "未填写";
                System.out.println(id +" "+ stu.getName() +" "+ stu.getAge() +" "+ address);
            }
        } catch (SQLException e) {
            System.out.println("操作失败" + e.getMessage());
        }

    }
}

