package com.Silas.API.lambda;

import com.Silas.StudentManagementSystem.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StudentGroupingDemo {
    static Predicate<Student> adultRule = student -> student.getAge() >= 18;
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

        Map<String, List<Student>> map1 = students.stream().collect(Collectors.groupingBy(Student::getAddress));
        Map<String,Long> map2 = students.stream().collect(Collectors.groupingBy(Student::getAddress,Collectors.counting()));
        Map<String,Long> map3 = students.stream().filter(adultRule).collect(Collectors.groupingBy(Student::getAddress,Collectors.counting()));
        for(Map.Entry<String,List<Student>> entry : map1.entrySet()){
            List<String> name = new ArrayList<>();
            for(Student stu : entry.getValue()){
                name.add(stu.getName());
            }
            System.out.println(entry.getKey() + " "+ name);
        }
        for(Map.Entry<String,Long> entry : map2.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        for(Map.Entry<String,Long> entry : map3.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

    }
}
