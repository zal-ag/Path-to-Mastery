package com.silas.student;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static com.silas.student.StudentParser.parse;

public class StudentFileStore {

    public static List<Student> loadStudents(Path path) throws IOException {
        List<Student> stuClass = new ArrayList<>();
        List<String> studentInfo = new ArrayList<>(Files.readAllLines(path));
        for(String info : studentInfo){
            stuClass.add(parse(info));
        }
        return stuClass;
    }

   public static void saveStudents(Path path,List<Student> students) throws IOException{
        StringBuilder sb = new StringBuilder();
        for(Student stu : students){
            sb.append(stu.getId()).append(",")
                    .append(stu.getName()).append(",")
                    .append(stu.getAge()).append(",")
                    .append(stu.getAddress()).append("\n");
        }
        Files.writeString(path,sb.toString());
   }
}
