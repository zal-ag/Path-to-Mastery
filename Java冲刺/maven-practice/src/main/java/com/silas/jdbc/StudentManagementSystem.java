package com.silas.jdbc;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.silas.student.Student;
import com.silas.student.StudentValidator;

public class StudentManagementSystem {
    static void main() {

        Scanner sc = new Scanner(System.in);

        try (Connection connection = DbConnectionFactory.getConnection()) {

            while (true) {
                System.out.println("【1】 查询学生信息");
                System.out.println("【2】 新增学生信息");
                System.out.println("【3】 修改学生信息");
                System.out.println("【4】 删除学生信息");
                System.out.println("【5】 查询全部学生");
                System.out.println("【0】 退出");
                String choice = sc.nextLine();

                switch (choice) {
                    case "1" -> {
                        // 输入学号
                        System.out.println("请输入学号：");
                        String id = sc.nextLine();
                        // 调用 StudentRepository.findById
                        Student stu = StudentRepository.findById(connection,id);
                        // 判断并展示查询结果
                        if(stu == null) {
                            System.out.println("未找到该学生");
                        }
                        else System.out.println(stu.getId() +" "+ stu.getName() +" "+ stu.getAge() +" "+ stu.getAddress());
                    }
                    case "2" -> {
                        try {
                            // 输入数据
                            System.out.println("请输入学生信息\n学号");
                            String id = sc.nextLine();
                            System.out.println("姓名：");
                            String name = sc.nextLine();
                            System.out.println("年龄：");
                            int age = StudentValidator.parseAge(sc.nextLine());
                            System.out.println("地址：");
                            String address = sc.nextLine();
                            // 创建 Student
                            Student stu = new Student(id,name,age,address);
                            // 调用 insert，根据返回行数提示
                            int rows = StudentRepository.insert(connection,stu);
                            if(rows == 1) System.out.println("添加成功");
                            else System.out.println("未添加学生，影响行数" + rows);
                        } catch (IllegalArgumentException e) {
                            System.out.println("输入有误：" + e.getMessage());
                        } catch (SQLException e) {
                            System.out.println("添加失败：" + e.getMessage());
                        }
                    }
                    case "3" -> {
                        try {
                            // 输入数据
                            System.out.println("请输入要修改的学生ID");
                            String id = sc.nextLine();
                            System.out.println("开始修改");
                            System.out.println("姓名：");
                            String name = sc.nextLine();
                            System.out.println("年龄：");
                            int age = StudentValidator.parseAge(sc.nextLine());
                            System.out.println("地址：");
                            String address = sc.nextLine();
                            // 创建 Student
                            Student stu = new Student(id,name,age,address);
                            // 调用 insert，根据返回行数提示
                            int rows = StudentRepository.updateById(connection,stu);
                            if(rows == 1) System.out.println("修改成功");
                            else System.out.println("未找到该学生");
                        } catch (IllegalArgumentException e) {
                            System.out.println("输入有误：" + e.getMessage());
                        } catch (SQLException e) {
                            System.out.println("修改失败：" + e.getMessage());
                        }
                    }
                    case "4" -> {
                        try {
                            // 输入数据
                            System.out.println("请输入要删除的学生ID");
                            String id = sc.nextLine();
                            // 调用 insert，根据返回行数提示
                            int rows = StudentRepository.deleteById(connection,id);
                            if(rows == 1) System.out.println("删除成功");
                            else System.out.println("未找到该学生");
                        } catch (SQLException e) {
                            System.out.println("删除失败：" + e.getMessage());
                        }
                    }
                    case "5" -> {
                        try{
                            List<Student> students = StudentRepository.findAll(connection);
                            if (students.isEmpty()) System.out.println("暂无学生信息");
                            else{
                                System.out.printf("共有%d名学生\n",students.size());
                                for(Student stu : students){
                                    String address = stu.getAddress();
                                    if (address == null) address = "未填写";
                                    System.out.println(stu.getId() +" "+ stu.getName() +" "+ stu.getAge() +" "+ address);
                                }
                            }
                        } catch (SQLException e) {
                            System.out.println("查询失败" + e.getMessage());
                        }

                    }
                    case "0" -> {
                        System.out.println("退出系统");
                        return;
                    }
                    default -> System.out.println("输入无效，请重新选择");
                }
            }

        } catch (SQLException | IOException e) {
            System.out.println("数据库操作失败：" + e.getMessage());
        }
    }
}
