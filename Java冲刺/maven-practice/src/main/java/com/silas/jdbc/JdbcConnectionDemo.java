package com.silas.jdbc;

import java.sql.*;
import java.util.Scanner;

public class JdbcConnectionDemo {
    static void main() {
        String url = "jdbc:mysql://127.0.0.1:3306/student_management";
        String username = "root";

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你的数据库密码：");
        String password = sc.nextLine();

        try(Connection connection =
                DriverManager.getConnection(url,username,password)) {
            System.out.println("数据库连接成功");
            String sql = "SELECT COUNT(*) AS student_count FROM student";
            try(PreparedStatement statement = connection.prepareStatement(sql)) {
                try(ResultSet resultSet = statement.executeQuery()) {
                    if(resultSet.next()) {
                        int count = resultSet.getInt("student_count");
                        System.out.println("学生总人数：" + count);
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("数据库操作失败：" + e.getMessage());
        }
    }
}
