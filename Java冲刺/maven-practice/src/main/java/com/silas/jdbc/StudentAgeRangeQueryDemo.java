package com.silas.jdbc;

import java.sql.*;
import java.util.Scanner;

public class StudentAgeRangeQueryDemo {
    static void main() {
        String url = "jdbc:mysql://127.0.0.1:3306/student_management";
        String username = "root";
        Scanner sc = new Scanner(System.in);
        System.out.printf("请输入%s用户密码\n",username);
        String password = sc.nextLine();
        int count = 0;
        try(Connection connection = DriverManager.getConnection(url,username,password)) {
            String sql = "SELECT id,name,age FROM student " +
                    "WHERE age >= ? AND age <= ? ORDER BY id ASC";
            try(PreparedStatement statement = connection.prepareStatement(sql)) {
                System.out.println("请输入最小年龄：");
                int min = sc.nextInt();
                System.out.println("请输入最大年龄：");
                int max = sc.nextInt();
                statement.setInt(1,min);
                statement.setInt(2,max);
                try(ResultSet resultSet = statement.executeQuery()){
                    while(resultSet.next()){
                        String id = resultSet.getString("id");
                        String name = resultSet.getString("name");
                        int age = resultSet.getInt("age");
                        System.out.println(id +" "+ name +" "+ age);
                        count++;
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("操作失败" + e.getMessage());
            return;
        }
    }
}
