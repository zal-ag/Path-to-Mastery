package com.Silas.API.lambda;

import com.Silas.StudentManagementSystem.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class StudentFilterDemo {

    static StudentRule adultRule = student -> student.getAge() >= 18;
    static StudentRule addressRule = student -> student.getAddress().equals("北京");

    static List<Student> filter(List<Student> students, StudentRule rule){
        List<Student> fitStudents = new ArrayList<>();
        for(Student stu : students){
            if(rule.test(stu)) fitStudents.add(stu);
        }
        return fitStudents;
    }

    Predicate<Student> adultRule1 = student -> student.getAge() >= 18;
    Predicate<Student> addressRule1 = student -> student.getAddress().equals("北京");

    static List<Student> filter1(List<Student> students, Predicate<Student> rule){
        List<Student> fitStudents = new ArrayList<>();
        for(Student stu : students){
            if(rule.test(stu)) fitStudents.add(stu);
        }
        return fitStudents;
    }

    void main() {
        List<Student> students = new ArrayList<>();
        Student stu1 = new Student("1001","张三",17,"北京");
        Student stu2 = new Student("1002","李四",20,"南京");
        Student stu3 = new Student("1003","王五",19,"北京");
        students.add(stu1);
        students.add(stu2);
        students.add(stu3);

        System.out.println("【成年】");
        List<Student> fitStudents1 = filter(students,adultRule);
        for(Student stu : fitStudents1){
            System.out.println(stu.getName() + " " + stu.getAge());
        }

        System.out.println("【在北京】");
        List<Student> fitStudents2 = filter(students,addressRule);
        for(Student stu : fitStudents2){
            System.out.println(stu.getName() + " " + stu.getAddress());
        }

        // 成年 且 在北京
        System.out.println("【成年 且 在北京】");
        List<Student> fitStudents3 = filter1(students,adultRule1.and(addressRule1));
        for(Student stu : fitStudents3){
            System.out.println(stu.getName() + " " + stu.getAge()+ " " + stu.getAddress());
        }
        // 成年 或 在北京
        System.out.println("【成年 或 在北京】");
        List<Student> fitStudents4 = filter1(students,adultRule1.or(addressRule1));
        for(Student stu : fitStudents4){
            System.out.println(stu.getName() + " " + stu.getAge()+ " " + stu.getAddress());
        }
        // 未成年
        System.out.println("【未成年】");
        List<Student> fitStudents5 = filter1(students,adultRule1.negate());
        for(Student stu : fitStudents5){
            System.out.println(stu.getName() + " " + stu.getAge()+ " " + stu.getAddress());
        }
        // 成年 且 不在北京
        System.out.println("【成年 且 不在北京】");
        List<Student> fitStudents6 = filter1(students,adultRule1.and(addressRule1.negate()));
        for(Student stu : fitStudents6){
            System.out.println(stu.getName() + " " + stu.getAge()+ " " + stu.getAddress());
        }
    }
}
