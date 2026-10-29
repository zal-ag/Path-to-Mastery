package com.silas.student;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static com.silas.student.StudentFileStore.saveStudents;


public class StudentFileStoreTest {

    @TempDir
    Path tempDir;

    @Test
    void loadValidStudents() throws IOException {

        // 准备测试数据
        Path file = tempDir.resolve("students.txt");
        Files.writeString(file,"1001,张三,20,北京\n1002,李四,19,上海");

        // 调用被测试的方法
        List<Student> students = StudentFileStore.loadStudents(file);

        // 验证结果
        Assertions.assertEquals(2,students.size());
        Assertions.assertEquals("1001",students.getFirst().getId());
        Assertions.assertEquals("张三",students.getFirst().getName());
        Assertions.assertEquals("1002",students.get(1).getId());
        Assertions.assertEquals("李四",students.get(1).getName());

    }

    @Test
    void loadEmptyFile() throws IOException {
        Path file = tempDir.resolve("studenst.txt");
        Files.writeString(file,"");
        List<Student> students = StudentFileStore.loadStudents(file);

        Assertions.assertTrue(students.isEmpty());
    }

    @Test
    void rejectsMissingFile() {
        Path file = tempDir.resolve("students.txt");
        Assertions.assertThrows(
                IOException.class,
                () -> StudentFileStore.loadStudents(file)
        );
    }

    @Test
    void rejectsInvalidRecord() throws IOException {
        Path file = tempDir.resolve("students.txt");
        Files.writeString(file,"1001,张三,20,北京\n1002,李四,abc,上海");
        Assertions.assertThrows(
                NumberFormatException.class,
                () -> StudentFileStore.loadStudents(file)
        );
    }

    @Test
    void savesAndLoadsStudents() throws IOException {
        Student stu1 = new Student("1001","张三",20,"北京");
        Student stu2 = new Student("1002","李四",19,"上海");
        List<Student> stuClass = new ArrayList<>();
        stuClass.add(stu1);
        stuClass.add(stu2);

        Path file = tempDir.resolve("students.txt");
        saveStudents(file,stuClass);

        List<Student> students = StudentFileStore.loadStudents(file);

        Assertions.assertEquals(2,students.size());
        Assertions.assertEquals("1001",students.getFirst().getId());
        Assertions.assertEquals("张三",students.getFirst().getName());
        Assertions.assertEquals(20,students.getFirst().getAge());
        Assertions.assertEquals("北京",students.getFirst().getAddress());
        Assertions.assertEquals("1002",students.get(1).getId());
        Assertions.assertEquals("李四",students.get(1).getName());
        Assertions.assertEquals(19,students.get(1).getAge());
        Assertions.assertEquals("上海",students.get(1).getAddress());
    }

    @Test
    void savingEmptyListClearsFile() throws IOException {
        Path file = tempDir.resolve("students.txt");
        Files.writeString(file,"1001,张三,20,北京");
        List<Student> stuClass = new ArrayList<>();
        saveStudents(file,stuClass);
        Assertions.assertEquals("",Files.readString(file));
    }

    @Test
    void rejectsBlankLine() throws IOException {
        Path file = tempDir.resolve("students.txt");
        Files.writeString(file,"1001,张三,20,北京\n\n1002,李四,19,上海");
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> StudentFileStore.loadStudents(file)
        );
    }
}
