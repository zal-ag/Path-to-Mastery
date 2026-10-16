package com.Silas.oop.senior.inferface2;

public class Test {
    static void main() {
        TableTennisPlayer ttp = new TableTennisPlayer("樊振东",28);
        System.out.println(ttp.getName()+" "+ttp.getAge()+"岁");
        ttp.study();
        ttp.english();
    }
}
