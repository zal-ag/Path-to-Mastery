package com.Silas.StudentManagementSystem;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class StudentFileStore {
    // 方法1：保存文件数据
    public static void saveStudents(Path path, ArrayList<Student> students) throws IOException {
        StringBuilder sb = new StringBuilder();
        for (Student stu : students) {
            sb.append(stu.getId() + ",").append(stu.getName() + ",").append((stu.getAge()) + ",").append(stu.getAddress()).append("\n");
        }
        Files.writeString(path, sb.toString());
    }

    // 方法二：加载数据，返回学生集合
    public static ArrayList<Student> loadStudents(Path path) throws IOException {
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
