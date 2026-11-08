package com.Silas.oop.senior.test5;

public class MajorCourseInstructor extends Teacher{
    private String subject;

    public MajorCourseInstructor() {
    }

    public MajorCourseInstructor(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void teach(){
        System.out.println("教专业课知识——");
    }
}
