package com.silas.studentweb.repository;

import com.silas.studentweb.model.Student;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {

    private final DataSource dataSource;

    public StudentRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Student> findByAgeRange(int minAge, int maxAge) throws SQLException{
        List<Student> students = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            String sql = "SELECT id,name,age,address FROM student WHERE age >= ? AND age <= ? ORDER BY id ASC ";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, minAge);
                statement.setInt(2, maxAge);
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        String Id = resultSet.getString("id");
                        String Name = resultSet.getString("name");
                        int Age = resultSet.getInt("age");
                        String Address = resultSet.getString("address");
                        students.add(new Student(Id,Name,Age,Address));
                    }
                    return students;
                } catch (SQLException e) {
                    throw new RuntimeException("查询学生失败", e);
                }
            }

        }
    }

    public Student findById(String id) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            String sql = "SELECT id,name,age,address FROM student WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        String Id = resultSet.getString("id");
                        String Name = resultSet.getString("name");
                        int Age = resultSet.getInt("age");
                        String Address = resultSet.getString("address");
                        return new Student(Id,Name,Age,Address);
                    } else return null;
                } catch (SQLException e) {
                    throw new RuntimeException("查询学生失败", e);
                }
            }

        }
    }

    public int insert(Student student) throws SQLException {
        try(Connection connection = dataSource.getConnection()) {
            String sql = "INSERT INTO student(id,name,age,address) VALUES(?,?,?,?)";
            try(PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1,student.getId());
                statement.setString(2,student.getName());
                statement.setInt(3,student.getAge());
                statement.setString(4,student.getAddress());
                return statement.executeUpdate();
            }
        }
    }

    public int update(String id,Student student) throws SQLException {
        try(Connection connection = dataSource.getConnection()) {
            String sql = "UPDATE student SET name = ?,age = ?,address = ? WHERE id = ?";
            try(PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1,student.getName());
                statement.setInt(2,student.getAge());
                statement.setString(3,student.getAddress());
                statement.setString(4,id);
                return statement.executeUpdate();
            }
        }
    }

    public int delete(String id) throws SQLException {
        try(Connection connection = dataSource.getConnection()) {
            String sql = "DELETE FROM student WHERE id = ?";
            try(PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1,id);
                return statement.executeUpdate();
            }
        }
    }

    public List<Student> findAll() throws SQLException {
        List<Student> result = new ArrayList<>();
        try(Connection connection = dataSource.getConnection()) {
            String sql = "SELECT id,name,age,address FROM student ORDER BY id ASC";
            try(PreparedStatement statement = connection.prepareStatement(sql)) {
                try(ResultSet resultSet = statement.executeQuery()) {
                    while(resultSet.next()) {
                        String id = resultSet.getString("id");
                        String name = resultSet.getString("name");
                        int age= resultSet.getInt("age");
                        String address = resultSet.getString("address");
                        result.add(new Student(id,name,age,address));
                    }
                }
            }
        }
        return result;
    }
}
