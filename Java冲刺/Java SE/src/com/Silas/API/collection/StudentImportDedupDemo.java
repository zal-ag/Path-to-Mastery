package com.Silas.API.collection;

import com.Silas.StudentManagementSystem.Student;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import com.Silas.StudentManagementSystem.StudentFileStore;

public class StudentImportDedupDemo {
    static void main() throws IOException {
        Path path = Path.of("D:/aaa/Path-to-Mastery/Java冲刺/oop/students-dedup-test.txt");
        List<Student> stuClass = StudentFileStore.loadStudents(path);
        for(Student stu : stuClass){
            System.out.println(stu.getId() + " " + stu.getName());
        }
    }
}
