package com.silas.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.silas.student.Student;

public class StudentRepository {

    // 提供学号，查询指定学生信息
    public static Student findById(Connection connection, String id) throws SQLException {
        String sql = "SELECT name,age,address FROM student WHERE id = ?";
        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1,id);
            try(ResultSet resultSet = statement.executeQuery()) {
                if(resultSet.next()) {
                    String name = resultSet.getString("name");
                    int age = resultSet.getInt("age");
                    String address = resultSet.getString("address");
                    return new Student(id,name,age,address);
                } else {
                    return null;
                }
            }
        }
    }

    // 新增学生信息
    public static int insert (Connection connection,Student student) throws SQLException {
        String sql = "INSERT student(id,name,age,address) VALUES(?,?,?,?)";
        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1,student.getId());
            statement.setString(2,student.getName());
            statement.setInt(3,student.getAge());
            statement.setString(4,student.getAddress());
            return statement.executeUpdate();
        }
    }

    // 使用对象的学号定位，修改相关学生信息
    public static int updateById(Connection connection,Student student) throws SQLException {
        String sql = "UPDATE student SET name = ?,age = ?,address = ? WHERE id = ?";
        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1,student.getName());
            statement.setInt(2,student.getAge());
            statement.setString(3,student.getAddress());
            statement.setString(4,student.getId());
            return statement.executeUpdate();
        }
    }

    // 删除指定学生信息
    public static int deleteById(Connection connection,String id) throws SQLException {
        String sql = "DELETE FROM student WHERE id = ?";
        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1,id);
            return statement.executeUpdate();
        }
    }

    // 打印全部学生信息
    public static List<Student> findAll(Connection connection) throws SQLException {
        String sql = "SELECT id,name,age,address FROM student ORDER BY id ASC";
        List<Student> students = new ArrayList<Student>();
        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            try(ResultSet resultSet = statement.executeQuery()) {
                while(resultSet.next()) {
                    String id = resultSet.getString("id");
                    String name = resultSet.getString("name");
                    int age = resultSet.getInt("age");
                    String address = resultSet.getString("address");
                    Student student = new Student(id,name,age,address);
                    students.add(student);
                }
            }
        }
        return students;
    }
}
