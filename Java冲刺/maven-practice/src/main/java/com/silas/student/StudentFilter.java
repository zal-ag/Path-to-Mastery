package com.silas.student;

import java.util.List;
import java.util.function.Predicate;

public class StudentFilter {
    public static List<Student>  findAdults(List<Student> students) {
        Predicate<Student> adultRule = student -> student.getAge() >= 18;
        return students.stream().filter(adultRule).toList();
    }
}
