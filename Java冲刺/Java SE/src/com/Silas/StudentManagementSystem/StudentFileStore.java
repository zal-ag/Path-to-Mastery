package com.Silas.StudentManagementSystem;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StudentFileStore {

    // 方法1：加载数据，返回学生集合
    public static List<Student> loadStudents(Path path) throws IOException {
        List<Student> stuClass = new ArrayList<>();
        // 新建一个集合，存储文件每行的信息
        List<String> stuInfo = new ArrayList<>(Files.readAllLines(path));
        Set<String> stuSet= new HashSet<>();
        // 对文件每行的信息分别进行拆解
        loop:for (int i = 0; i < stuInfo.size(); i++) {
            String record = stuInfo.get(i);
            // 将每行的信息拆分到数组中
            String[] stuArr = record.split(",",-1);
            for(int j = 0; j < stuArr.length; j++) {
                stuArr[j] = stuArr[j].strip();
                if (stuArr[j].isEmpty()) {
                    System.out.printf("第%d行传入空字段\n",i+1);
                    continue loop;
                }
            }
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
                if(stuSet.add(stuArr[0])){
                    Student s = new Student(stuArr[0], stuArr[1], age, stuArr[3]);
                    stuClass.add(s);
                }else{
                    System.out.printf("第%d行有重复学号：%s\n",i+1,stuArr[0]);
                }
            } catch (NumberFormatException e) {
                System.out.printf("第%d行，年龄格式错误%n", i + 1);
            }
        }
        return stuClass;
    }

    // 方法2：将加载出的学生保存到文件中
    public static void saveStudents(Path path, List<Student> students) throws IOException {
        StringBuilder sb = new StringBuilder();
        for (Student stu : students) {
            sb.append(stu.getId()).append(",").append(stu.getName()).append(",").append(stu.getAge()).append(",").append(stu.getAddress()).append("\n");
        }
        Files.writeString(path, sb.toString());
    }


}
