package com.Silas.API.lambda;

import com.Silas.StudentManagementSystem.Student;

@FunctionalInterface
public interface StudentRule {
    boolean test(Student student);
}
