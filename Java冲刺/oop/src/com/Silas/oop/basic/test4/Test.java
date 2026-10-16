package com.Silas.oop.basic.test4;

public class Test {
    static void main() {
        Student s = new Student();
        s.setName("张三");
        s.setAge(18);
        s.setHeight(183);
        s.setWeight(60);

        System.out.printf("大一新生，%s,%d岁，%dcm，%dkg%n",s.getName(),s.getAge(),s.getHeight(),s.getWeight());
        s.study();
        s.setAge(s.getAge()+1);

        s.setWeight(s.getWeight()+10);
        s.setAge(s.getAge()+1);
        System.out.println("大二期间张三体重增长了10kg");

        s.setHeight(s.getHeight()+2);
        s.setWeight(s.getWeight()-3);
        s.setAge(s.getAge()+1);
        System.out.println("大三期间张三身高增长了2cm，体重减少了3kg");

        s.setAge(s.getAge()+1);
        System.out.printf("大学毕业，%s,%d岁，%dcm，%dkg",s.getName(),s.getAge(),s.getHeight(),s.getWeight());


    }

}
