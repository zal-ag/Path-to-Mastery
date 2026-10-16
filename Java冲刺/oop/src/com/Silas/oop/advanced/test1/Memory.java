package com.Silas.oop.advanced.test1;

public class Memory {
    static void main() {
        Student stu = new Student();
        System.out.println(stu);
        /*
        直接打印得到的是，stu 对应的在堆内存中的地址，
        com.Silas.oop.advanced.test1.test2.Student@23fc625e
        拆解：包名+类名+地址
         */
    }
}
