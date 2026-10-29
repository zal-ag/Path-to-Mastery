package com.silas.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentDeleteDemo {
    static void main() {
        String url = "jdbc:mysql://127.0.0.1:3306/student_management";
        String username = "root";
        Scanner sc = new Scanner(System.in);
        System.out.printf("请输入%s用户密码\n",username);
        String password = sc.nextLine();
        int count = 0;
        try(Connection connection = DriverManager.getConnection(url,username,password)) {
            String id = "1007";
            int rows = StudentRepository.deleteById(connection,id);
            if(rows == 1) System.out.println("删除成功");
            else if(rows == 0) System.out.println("未找到该学生，无需删除");
        } catch (SQLException e) {
            System.out.println("操作失败" + e.getMessage());
        }
    }
}
