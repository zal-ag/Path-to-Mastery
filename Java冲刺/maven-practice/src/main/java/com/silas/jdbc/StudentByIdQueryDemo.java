package com.silas.jdbc;

import com.silas.student.Student;

import java.sql.*;
import java.util.Scanner;

public class StudentByIdQueryDemo {
    static void main() {
        String url = "jdbc:mysql://127.0.0.1:3306/student_management";
        String username = "root";
        Scanner sc = new Scanner(System.in);
        System.out.printf("请输入%s用户密码\n",username);
        String password = sc.nextLine();
        try(Connection connection = DriverManager.getConnection(url,username,password)) {
            System.out.println("数据库连接成功");
            String sql = "SELECT id,name,age,address FROM student WHERE id = ?";
            try(PreparedStatement statement = connection.prepareStatement(sql)) {
                System.out.println("请输入要查询的学生学号");
                String inputId = sc.nextLine();
                statement.setString(1,inputId);
                try(ResultSet resultSet = statement.executeQuery()) {
                    if(resultSet.next()){
                        String id = resultSet.getString("id");
                        String name = resultSet.getString("name");
                        int age = resultSet.getInt("age");
                        String address = resultSet.getString("address");
                        if(address == null) address = "未填写";
                        Student stu = new Student(id,name,age,address);
                        System.out.println(stu.getId() +" "+ stu.getName() +" "+ stu.getAge() +" "+ stu.getAddress());
                    }else{
                        System.out.println("未找到该学生");
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("操作失败" + e.getMessage());
        }

    }
}
