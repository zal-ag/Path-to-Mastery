package com.silas.student;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentFilterTest {

    @Test
    void findAdultWithoutChangingSource() {
        Student stu1 = new Student("1001","张三",17,"北京");
        Student stu2 = new Student("1002","李四",18,"北京");
        Student stu3 = new Student("1003","王五",20,"北京");
        List<Student> students = new ArrayList<>(Arrays.asList(stu1,stu2,stu3));
        List<Student> result = StudentFilter.findAdults(students);

        Assertions.assertEquals(2,result.size());
        Assertions.assertEquals("1002",result.getFirst().getId());
        Assertions.assertEquals("1003",result.get(1).getId());

        Assertions.assertEquals(3,students.size());
        Assertions.assertEquals("1001",students.getFirst().getId());
        Assertions.assertEquals("1002",students.get(1).getId());
        Assertions.assertEquals("1003",students.get(2).getId());
    }

    @Test
    void returnsEmptyListForEmptyInput() {
        List<Student> students = new ArrayList<>();
        List<Student> result = StudentFilter.findAdults(students);
        Assertions.assertTrue(result.isEmpty());

    }
}
