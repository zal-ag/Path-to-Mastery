package com.Silas.API.generics;


import com.Silas.StudentManagementSystem.Student;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericMethodDemo {
    static void main() {
        List<String> list1 = new ArrayList<>(Arrays.asList("Ran","Zoe","Sheng"));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(1,2,3));
        List<Student> list3 = new ArrayList<>();
        Student stu1 = new Student("101","silas",19,"China");
        list3.add(stu1);
        System.out.println(ListTools.first(list1));
        System.out.println(ListTools.first(list2));
        System.out.println(ListTools.first(list3).getName());
        System.out.println(ListTools.first(new ArrayList<Integer>()));

        ListTools.printAll(list1);
        ListTools.printAll(list2);

        System.out.println(ListTools.sum(list2));
        List<Double> list4 = new ArrayList<>(Arrays.asList(1.5,2.5));
        System.out.println(ListTools.sum(list4));
        System.out.println(ListTools.sum(new ArrayList<Integer>()));

    }
}
