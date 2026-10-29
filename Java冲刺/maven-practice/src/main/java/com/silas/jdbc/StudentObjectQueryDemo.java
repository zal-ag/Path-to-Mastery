package com.silas.jdbc;

import com.silas.student.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentObjectQueryDemo {
    static void main() {
        String url = "jdbc:mysql://127.0.0.1:3306/student_management";
        String username = "root";
        Scanner sc = new Scanner(System.in);
        System.out.printf("请输入%s用户密码\n", username);
        String password = sc.nextLine();

        List<Student> students = new ArrayList<>();

        try (Connection connection =
                     DriverManager.getConnection(url, username, password)) {
            System.out.println("数据库连接成功");
            String sql = "SELECT id,name,age,address FROM student ORDER BY id ASC";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        String id = resultSet.getString("id");
                        String name = resultSet.getString("name");
                        int age = resultSet.getInt("age");
                        String address = resultSet.getString("address");
                        Student stu = new Student(id, name, age, address);
                        students.add(stu);
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("操作失败：" + e.getMessage());
            return;
        }
        System.out.printf("成功加载%d名学生\n",students.size());
        for(Student stu : students){
            String address = stu.getAddress();
            if(address == null) address = "未填写";
            System.out.println(stu.getId() +" "+ stu.getName() +" "+ stu.getAge() +" "+ address);
        }
    }
}
