package com.silas.jdbc;

import com.silas.student.Student;

import java.sql.*;
import java.util.Scanner;

public class JdbcTransactionDemo {
    static void main() {
        String url = "jdbc:mysql://127.0.0.1:3306/student_management";
        String username = "root";
        Scanner sc = new Scanner(System.in);
        System.out.printf("请输入%s用户密码\n",username);
        String password = sc.nextLine();
        try(Connection connection = DriverManager.getConnection(url,username,password)) {
            connection.setAutoCommit(false);
            try {
                Student firstStudent = new Student("tx001", "事务甲", 30, "北京");
                Student secondStudent = new Student("tx002", "事务乙", 121, "上海");
                int firstRows = StudentRepository.updateById(connection, firstStudent);
                int secondRows = StudentRepository.updateById(connection, secondStudent);

                if (firstRows == 1 && secondRows == 1) {
                    connection.commit();
                    System.out.println("两名学生修改成功，已提交");
                } else {
                    connection.rollback();
                    System.out.println("未能同时修改两名学生，已回滚");
                }
            } catch (SQLException e) {
                connection.rollback();
                System.out.println("操作失败，已回滚：" + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("连接、回滚或资源关闭失败：" + e.getMessage());
        }
    }
}
