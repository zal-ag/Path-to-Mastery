package com.Silas.API.ArrayList.BasicDemo3;

import java.util.ArrayList;

public class Demo3 {
    static void main() {
        ArrayList<Student> list = new ArrayList<>();

        Student s1 = new Student("Silas",19);
        Student s2 = new Student("Ran",22);
        Student s3 = new Student("Zoe",23);

        list.add(s1);
        list.add(s2);
        list.add(s3);

        System.out.println(list);

        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            System.out.println(stu.getName()+" "+stu.getAge());
        }
    }
}
