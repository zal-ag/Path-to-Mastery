package com.Silas.StudentManagementSystem;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.ArrayList;

import static com.Silas.StudentManagementSystem.Def.*;
import static com.Silas.StudentManagementSystem.StudentFileStore.*;

public class Menu {

    public static void studentInfo() {

        ArrayList<Student> list = new ArrayList<>();
        Path path = Path.of("D:/aaa/Path-to-Mastery/Java冲刺/oop/src/com/Silas/StudentManagementSystem/Student1.txt");
        try{
            list = loadStudents(path);
        }catch(NoSuchFileException e){
            System.out.println("暂无学生数据");
        }catch(IOException e){
            System.out.println("加载失败");
            return;
        }
        loop:while(true){
            System.out.println("----------欢迎进入学生管理系统----------");
            System.out.println("【1】添加学生信息");
            System.out.println("【2】删除学生信息");
            System.out.println("【3】修改学生信息");
            System.out.println("【4】查询学生信息");
            System.out.println("【5】退出系统");
            System.out.println("请输入您的选择：");


            String choose = sc.next();

            switch(choose) {
                case "1"-> addStudent(list);
                case "2"-> deleteStudent(list);
                case "3"-> updateStudent(list);
                case "4"-> checkStudent(list);
                case "5"-> {
                    try{
                        saveStudents(path,list);
                        System.out.println("保存成功");
                        System.out.println("【退出系统】");
                        break loop;
                    }catch(IOException e){
                        System.out.println("出现异常");
                        e.printStackTrace();
                    }
                }
                default -> System.out.println("输入无效");
            }
        }

    }


}
