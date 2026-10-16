package com.Silas.oop.basic.test2;

public class Test {
    static void main() {
        // 创建对象
        Teacher t1 = new Teacher();

        t1.name = "娜娜";
        t1.age = 18;

        System.out.println("姓名：" + t1.name);
        System.out.println("年龄：" + t1.age);
        t1.teach();
        t1.eat();
        t1.sleep();
    }

}
