package com.Silas.API.lambda;

import com.Silas.StudentManagementSystem.Student;
import com.Silas.StudentManagementSystem.StudentFileStore;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StudentsReportDemo {

    static Predicate<Student> adultRule = student -> student.getAge() >= 18;
    static Comparator<Student> byAge = Comparator.comparingInt(Student::getAge).reversed().thenComparing(Student::getId);

    static void main() {
        Path path = Path.of("D:/aaa/Path-to-Mastery/Java冲刺/oop/students-report-test.txt");
        try {
            List<Student> students = StudentFileStore.loadStudents(path);
            if (students.isEmpty()) {
                System.out.println("暂无学生数据");
                return;
            }
            printReport(students);
        } catch(IOException e){
            System.out.println("读取失败");
            e.printStackTrace();
        }

    }

    static void printReport(List<Student> students){
        // part 1
        System.out.println("【学生统计】");
        System.out.println("有效学生："+students.size());
        long adultCount = students.stream()
                .filter(adultRule)
                .count();
        System.out.println("成年学生:" + adultCount);
        // part 2
        System.out.println("【年龄最大的两名成年学生】");
        List<Student> oldStudents = students.stream()
                .filter(adultRule)
                .sorted(byAge)
                .limit(2)
                .toList();
        for(Student stu : oldStudents){
            System.out.println(stu.getId() + " " + stu.getName() + " " + stu.getAge());
        }
        // part 3
        System.out.println("【各城市人数】");
        Map<String,Long> diffAddressStudents = students.stream()
                .collect(Collectors.groupingBy(Student::getAddress,Collectors.counting()));
        for(Map.Entry<String,Long> entry : diffAddressStudents.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
