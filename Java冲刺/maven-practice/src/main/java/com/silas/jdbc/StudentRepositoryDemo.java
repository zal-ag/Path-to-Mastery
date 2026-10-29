package com.silas.jdbc;

import java.sql.*;
import java.util.Scanner;
import com.silas.student.Student;

public class StudentRepositoryDemo {
    static void main() {
        String url = "jdbc:mysql://127.0.0.1:3306/student_management";
        String username = "root";
        System.out.printf("请输入%s用户密码\n",username);
        Scanner sc = new Scanner(System.in);
        String password = sc.nextLine();
        try(Connection connection = DriverManager.getConnection(url,username,password)) {
            // 先查询该学号（1007）有无对应信息
            // 有，则打印并返回；无，则继续操作
            Student stu1 = StudentRepository.findById(connection,"1007");
            if(stu1 == null) System.out.println("学生信息不存在");
            else {
                System.out.println(stu1.getId() +" "+ stu1.getName() +" "+ stu1.getAge() +" "+ stu1.getAddress());
                return;
            }
            // 新增该学号（1007）对应的学生信息
            Student stu2 = new Student("1007","孙八",21,"杭州");
            StudentRepository.insert(connection,stu2);
            // 新增后进行检查
            Student stu3 = StudentRepository.findById(connection,"1007");
            if(stu3 == null) {
                System.out.println("添加失败");
                return;
            }
            else {
                System.out.println("添加成功");
                System.out.println(stu3.getId() +" "+ stu3.getName() +" "+ stu3.getAge() +" "+ stu3.getAddress());
            }
            // 修改信息
            Student stu4 = new Student("1007","孙九",22,"南京");
            int rows1 = StudentRepository.updateById(connection,stu4);
            if(rows1 == 1) {
                System.out.println("修改成功");
                Student stu5 = StudentRepository.findById(connection,"1007");
                if(stu5 != null) System.out.println(stu5.getId() +" "+ stu5.getName() +" "+ stu5.getAge() +" "+ stu5.getAddress());
            }else if(rows1 == 0) {
                System.out.println("修改失败");
                return;
            }
            // 删除该信息
            int rows2 = StudentRepository.deleteById(connection,"1007");
            if(rows2 == 1){
                Student stu6 = StudentRepository.findById(connection,"1007");
                if(stu6 == null) {
                    System.out.println("删除成功，已确认记录不存在");
                }else{
                    System.out.println("删除验收失败，仍然能查询到学生");
                }
            }else if (rows2 == 0) System.out.println("删除失败");
        } catch (SQLException e) {
            System.out.println("操作异常" + e.getMessage());
        }
    }
}
