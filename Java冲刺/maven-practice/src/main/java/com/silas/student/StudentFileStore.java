package com.silas.student;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static com.silas.student.StudentParser.parse;

public class StudentFileStore {

    public static List<Student> loadStudents(Path path) throws IOException {
        List<Student> stuClass = new ArrayList<>();
        try(BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)){
            String content = reader.readLine();
            while(content != null){
                stuClass.add(parse(content));
                content = reader.readLine();
            }
        }
        return stuClass;
    }

   public static void saveStudents(Path path,List<Student> students) throws IOException{
        try(BufferedWriter writer = Files.newBufferedWriter(path)){
            for(Student stu : students){
                String record = stu.getId()+","+stu.getName()+","+stu.getAge()+","+stu.getAddress();
                writer.write(record);
                writer.newLine();
            }
        }
   }
}
