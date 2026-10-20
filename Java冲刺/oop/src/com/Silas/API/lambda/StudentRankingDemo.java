package com.Silas.API.lambda;

import com.Silas.StudentManagementSystem.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class StudentRankingDemo {

    static Predicate<Student> adultRule = student -> student.getAge() >= 18;
    static Comparator<Student> byAge = Comparator.comparingInt(Student::getAge).reversed().thenComparing(Student::getId);



    static void main() {
        List<Student> students = new ArrayList<>();
        Student stu1 = new Student("1003","王五",20,"北京");
        Student stu2 = new Student("1001","张三",17,"北京");
        Student stu3 = new Student("1004","赵六",22,"广州");
        Student stu4 = new Student("1002","李四",20,"南京");
        students.add(stu1);
        students.add(stu2);
        students.add(stu3);
        students.add(stu4);

        List<Student> fitStudents = students.stream().filter(adultRule).sorted(byAge).limit(2).toList();

        for(Student stu : fitStudents){
            System.out.println(stu.getId()+" "+stu.getName()+" "+stu.getAge());
        }
        for(Student stu : students){
            System.out.println(stu.getId());
        }
    }
}
