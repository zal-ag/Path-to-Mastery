package com.silas.jdbc;

import com.silas.student.Student;

import java.sql.*;
import java.util.Scanner;

public class StudentInsertDemo {
    static void main() {
        String url = "jdbc:mysql://127.0.0.1:3306/student_management";
        String username = "root";
        Scanner sc = new Scanner(System.in);
        System.out.printf("请输入%s用户密码\n",username);
        String password = sc.nextLine();
        try(Connection connection = DriverManager.getConnection(url,username,password)) {
            Student stu = new Student("1007","孙八",21,"杭州");
            int rows = StudentRepository.insert(connection,stu);
            if(rows == 1) System.out.println("新增学生信息成功！");
        } catch (SQLException e) {
            System.out.println("操作失败" + e.getMessage());
        }
    }
}
