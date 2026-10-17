package com.Silas.API.collection;

import com.Silas.StudentManagementSystem.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentMapIndexDemo {
    static void main() {
        List<Student> students = new ArrayList<Student>();
        students.add(new Student("1001","张三",20,"北京"));
        students.add(new Student("1002","李四",19,"上海"));
        students.add(new Student("1001","王五",22,"深圳"));
        students.add(new Student("1003","张三",21,"广州"));
        Map<String,Student> studentsMap = buildStudentMap(students);
        System.out.println("原列表人数：" + students.size());
        System.out.println("有效学号数量：" + studentsMap.size());
        System.out.println("1001对应姓名" + studentsMap.get("1001").getName());
    }
    static Map<String,Student> buildStudentMap(List<Student> students){
        Map<String,Student> studentsMap = new HashMap<>();
        for(Student stu : students){
            if(studentsMap.containsKey(stu.getId())){
                System.out.println("重复学号：" + stu.getId());
            }else{
                studentsMap.put(stu.getId(),stu);
            }
        }
        return studentsMap;
    }

}
