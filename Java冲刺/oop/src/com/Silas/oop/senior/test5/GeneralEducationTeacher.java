package com.Silas.oop.senior.test5;

public class GeneralEducationTeacher extends Teacher {
    public GeneralEducationTeacher() {
    }

    public GeneralEducationTeacher(String name, int age) {
        super(name, age);
    }
    public void teach(){
        System.out.println("教通识课知识——");
    }
}
