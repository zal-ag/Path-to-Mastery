package com.silas.jdbc;

import com.silas.student.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentUpdateDemo {
    static void main() {
        String url = "jdbc:mysql://127.0.0.1:3306/student_management";
        String username = "root";
        Scanner sc = new Scanner(System.in);
        System.out.printf("请输入%s用户密码\n",username);
        String password = sc.nextLine();
        int count = 0;
        try(Connection connection = DriverManager.getConnection(url,username,password)) {
            Student stu = new Student("1007","孙九",22,"南京");
            int rows = StudentRepository.updateById(connection,stu);
            if(rows == 1) System.out.println("学生信息更新成功");
            else if(rows == 0) System.out.println("未匹配到要修改的学生");
        } catch (SQLException e) {
            System.out.println("操作失败" + e.getMessage());
        }
    }
}
