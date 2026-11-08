package com.Silas.API.lambda;

import com.Silas.StudentManagementSystem.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class StudentFunctionDemo {

    static Predicate<Student> adultRule = student -> student.getAge() >= 18;
    static Function<Student,String> toSummary = student -> student.getName()+"-"+student.getAddress();
    static Consumer<String> printer = info -> System.out.println(info);

    static void main() {
        List<Student> students = new ArrayList<>();
        Student stu1 = new Student("1001","张三",17,"北京");
        Student stu2 = new Student("1002","李四",20,"南京");
        Student stu3 = new Student("1003","王五",19,"北京");
        students.add(stu1);
        students.add(stu2);
        students.add(stu3);

        for(Student stu : students){
            if(adultRule.test(stu)){
                String info = toSummary.apply(stu);
                printer.accept(info);
            }
        }
    }
}
