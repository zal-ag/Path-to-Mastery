package com.Silas.StudentManagementSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Def {

    static Scanner sc = new Scanner(System.in);

    public static void addStudent(ArrayList<Student> list){
        System.out.println("【添加学生信息】");
        Student s = new Student();
        System.out.println("输入学生id");
        String id;
        while(true){
            id = sc.next();
            boolean sign = true;
            for (Student stu:list) {
                if(id.equals(stu.getId())){
                    System.out.println("该id无效，请重新输入");
                    sign = false;
                    break;
                }
            }
            if(sign) {
                s.setId(id);
                break;
            }
        }
        System.out.println("输入学生姓名");
        String name = sc.next();
        s.setName(name);
        System.out.println("输入学生年龄");
        s.setAge(readAge());
        System.out.println("输入学生地址");
        String address = sc.next();
        s.setAddress(address);
        list.add(s);
        System.out.println("学生信息添加成功！");
    }

    public static void deleteStudent(ArrayList<Student> list){
        System.out.println("【删除学生信息】");
        System.out.println("请输入要删除学生的id：");
        String id = sc.next();
        Student stu = findStudent(list,id);
        if(stu == null) {
            System.out.println("该id不存在");
            return;
        }
        list.remove(stu);
        System.out.println("删除成功");

    }

    public static void updateStudent(ArrayList<Student> list){
        System.out.println("【修改学生信息】");
        System.out.println("请输入要修改学生的id：");
        String id = sc.next();
        Student stu = findStudent(list,id);
        if(stu == null) {
            System.out.println("该id不存在");
            return;
        }
        System.out.println("输入学生姓名");
        String name = sc.next();
        System.out.println("输入学生年龄");
        int age = readAge();
        System.out.println("输入学生地址");
        String address = sc.next();
        System.out.println("确认修改？y/n）");
        while(true){
            String confirm = sc.next();
            if(confirm.equals("y")){
                stu.setName(name);
                stu.setAge(age);
                stu.setAddress(address);
                System.out.println("修改成功");
                break;
            }else if(confirm.equals("n")){
                System.out.println("已取消修改");
                return;
            }else{
                System.out.println("输入格式错误，请重新输入");
            }
        }
    }

    public static int readAge() {
        while (true) {
            String ageStr = null;
            try {
                ageStr = sc.next();
                int age = Integer.parseInt(ageStr);
                if (age < 1 || age > 120) {
                    System.out.println("年龄超出限制，请重新输入");
                    continue;
                }
                System.out.println("年龄输入成功");
                return age;
            } catch (NumberFormatException e) {
                System.out.printf("输入格式错误（%s）,请重新输入%n", ageStr);
            }
        }
    }

    public static void checkStudent(ArrayList<Student> list){
        System.out.println("【查询学生信息】");
        if(list.isEmpty()) {
            System.out.println("当前无学生信息，请添加后再查询");
            return;
        }
        System.out.println("id\t\t姓名\t\t年龄\t\t家庭住址");
        for (Student stu : list) {
            System.out.println(stu.getId() + "\t" + stu.getName() + "\t\t" + stu.getAge() + "\t\t" + stu.getAddress());

        }
    }

    public static Student findStudent(ArrayList<Student> list,String id){
        for(Student stu: list){
            if(id.equals(stu.getId())) return stu;
        }
        return null;
    }
}
