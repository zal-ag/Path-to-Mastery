package com.silas.student;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class AdultStudentExportDemo {
    static void main() {
        try {
            Path path = Path.of("target","export-source.txt");
            Files.writeString(path, """
                1001,张三,17,北京
                1002,李四,20,上海
                1003,王五,18,广州""");
            List<Student> students = StudentFileStore.loadStudents(path);
            List<Student> stuClass = StudentFilter.findAdults(students);

            Path target = Path.of("target","export-adults.txt");
            StudentFileStore.saveStudents(target,stuClass);
            System.out.println("保存成功");
            System.out.printf("读取%d名学生，导出%d名成年学生\n",students.size(),stuClass.size());
            String content = Files.readString(target);
            System.out.println(content);
        } catch (IOException | IllegalArgumentException e) {
            System.out.println("导出失败：" + e.getMessage());
        }

    }
}
