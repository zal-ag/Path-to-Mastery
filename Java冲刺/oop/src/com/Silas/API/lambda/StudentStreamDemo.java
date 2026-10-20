package com.Silas.API.lambda;

import com.Silas.StudentManagementSystem.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class StudentStreamDemo {
    static Predicate<Student> adultRule = student -> student.getAge() >= 18;
    static Function<Student,String> toSummary = student -> student.getName()+"-"+student.getAddress();
    static Consumer<String> printer = System.out::println;

    static Predicate<Student> addressRule = student -> student.getAddress().equals("北京");
    static Function<Student,Integer> toAge = Student::getAge;
    static Function<Student,String> toName = Student::getName;

    static void main() {
        List<Student> students = new ArrayList<>();
        Student stu1 = new Student("1001","张三",17,"北京");
        Student stu2 = new Student("1002","李四",20,"南京");
        Student stu3 = new Student("1003","王五",19,"北京");
        students.add(stu1);
        students.add(stu2);
        students.add(stu3);

        students.stream().filter(adultRule).map(toSummary).forEach(printer);

        List<Integer> lists = students.stream().filter(addressRule).map(toAge).toList();
        System.out.println(lists);
        System.out.println(lists.size());

        students.add(new Student("1003","王五",19,"北京"));
        List<String> nameList = students.stream().filter(addressRule).map(toName).distinct().toList();
        System.out.println("北京学生的不重复姓名" + nameList);
        long adultCount = students.stream().filter(adultRule).count();
        System.out.println("成年人数：" + adultCount);
        System.out.println("原列表人数：" + students.size());

    }
}
