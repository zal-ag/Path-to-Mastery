package com.Silas.Files.multiInfoFiles;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.nio.file.Files;
import java.util.Arrays;
import java.lang.StringBuilder;

public class Main {
    static void main() {
        ArrayList<Student> stuClass;
        // 设置文件地址 1.要读取的文件 2.要写入的文件
        Path path = Path.of("D:/aaa/Path-to-Mastery/Java冲刺/oop/src/com/Silas/Files/multiInfoFiles/Student.txt");
        Path path1 = Path.of("D:/aaa/Path-to-Mastery/Java冲刺/oop/src/com/Silas/Files/students-clean.txt");
        try {
            stuClass = loadStudents(path);
            System.out.printf("成功加载%d名学生%n", stuClass.size());
            for (Student stu : stuClass) {
                System.out.println(stu.getId() + " " + stu.getName() + " " + stu.getAge() + " " + stu.getAddress());
            }
        } catch (IOException e) {
            System.out.println("出现异常" + e.getMessage());
            return;
        }

        try {
            saveStudents(path1, stuClass);
            System.out.println("保存学生信息成功");
            System.out.println("从文件中读取学生信息");
            String content = Files.readString(path1);
            System.out.println(content);
            System.out.println("读取学生信息成功");
        } catch (IOException e) {
            System.out.println("保存或读取失败");
            e.printStackTrace();
        }
    }

    // 方法1：保存文件数据
    static void saveStudents(Path path, ArrayList<Student> students) throws IOException {
        StringBuilder sb = new StringBuilder();
        for (Student stu : students) {
            sb.append(stu.getId() + ",").append(stu.getName() + ",").append((stu.getAge()) + ",").append(stu.getAddress()).append("\n");
        }
        System.out.println("将加载成功的学生信息存储到文件中");
        Files.writeString(path, sb.toString());
    }

    // 方法二：加载数据，返回学生集合
    static ArrayList<Student> loadStudents(Path path) throws IOException {
        ArrayList<Student> stuClass = new ArrayList<>();
        // 新建一个集合，存储文件每行的信息
        ArrayList<String> stuInfo = new ArrayList<>(Files.readAllLines(path));
        // 对文件每行的信息分别进行拆解
        for (int i = 0; i < stuInfo.size(); i++) {
            String record = stuInfo.get(i);
            // 将每行的信息拆分到数组中
            String[] stuArr = record.split(",");
            // 1.判断字段数量是否正确
            if (stuArr.length != 4) {
                System.out.printf("第%d行，字段数量错误%n", i + 1);
                continue;
            }
            // 2.年龄字段格式是否正确
            try {
                int age = Integer.parseInt(stuArr[2]);
                // 3.年龄的范围是否正确
                if (age < 1 || age > 120) {
                    System.out.printf("第%d行，年龄超出范围%n", i + 1);
                    continue;
                }
                // 若三个条件全部满足，则把数组中的数据存到学生对象中
                Student s = new Student(stuArr[0], stuArr[1], age, stuArr[3]);
                stuClass.add(s);
            } catch (NumberFormatException e) {
                System.out.printf("第%d行，年龄格式错误%n", i + 1);
            }
        }
        return stuClass;
    }
}
