package com.Silas.API.collection.equality;

import java.util.HashSet;
import java.util.Set;

public class StudentIdentitySetDemo {
    static void main() {
        StudentIdentity a = new StudentIdentity("1001", "张三");
        StudentIdentity b = new StudentIdentity("1001", "王五");
        System.out.println(a == b);
        System.out.println(a.equals(b));
        System.out.println(a.hashCode() == b.hashCode());
        Set<StudentIdentity> students = new HashSet<>();
        System.out.println(students.add(a));
        System.out.println(students.add(b));
        System.out.println(students.size());
    }
}
