package com.silas.student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentParser {
    public static Student parse(String record) throws NumberFormatException {
        if(record == null) throw new IllegalArgumentException();
        String[] Info = record.split(",",-1);
        if(Info.length != 4) throw new IllegalArgumentException("学生记录必须有四个字段，实际只有" + Info.length + "个");
        for(int i = 0; i < Info.length; i++){
            Info[i] = Info[i].strip();
            if(Info[i].isEmpty()) throw new IllegalArgumentException();
        }
        int age = StudentValidator.parseAge(Info[2]);
        return new Student(Info[0],Info[1],age,Info[3]);
    }
}
