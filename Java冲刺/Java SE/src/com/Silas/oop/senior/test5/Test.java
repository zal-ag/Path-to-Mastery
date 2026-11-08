package com.Silas.oop.senior.test5;

public class Test {
    static void main() {
        Undergraduate ug = new Undergraduate("Silas",19,"大二");
        System.out.println(ug.getName()+","+ug.getAge()+","+ug.getGrade());
        ug.eat();
        ug.sleep();
        ug.study();
        Postgraduate pg = new Postgraduate("Silas",23,"研二");
        System.out.println(pg.getName()+","+pg.getAge()+","+pg.getGrade());
        pg.eat();
        pg.sleep();
        pg.study();

    }
}
