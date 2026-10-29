package com.Silas.oop.advanced.InnerClass;

import com.Silas.StudentManagementSystem.Student;

public class InnerTest {
    static void main() {

        // 测试【成员内部类】
        Outer outer = new Outer(); // 先有外部对象
        Outer.Inner1 inner1 = outer.new Inner1(); // 再创建与它相关联的内部对象
        inner1.show(); // 可以访问外部类的私有成员

        // 测试【静态内部类】
        Outer.Inner2 inner2 = new Outer.Inner2(); // 创建静态内部类对象不需要先创建 Outer对象
        inner2.show(); // 可以直接访问外部类的静态成员
        inner2.showOuter(new Outer()); // 访问外部类的实例成员，需要提供外部对象

        // 测试【局部内部类】
        new Outer().show();

        // 测试【匿名内部类
        StudentRule adultRule = new StudentRule(){
            @Override
            public boolean test(Student student){
                return student.getAge() >= 18;
            }
        };
        /*
            代码拆解：
            StudentRule：接口引用，作为变量的类型
            adultRule：变量名
            =：右边的创建出对象的地址赋值给左边变量
            new：告诉 JVM 在堆内存中开辟出一块空间，准备创建对象
            StudentRule()：匿名类的创建语法，准备创建一个实现 StudentRule 接口的匿名类
            {：匿名类的类体开始标志
            @Override：注解，告诉编译器：“下面这个方法是我重写接口里的”
            重写方法忽略不讲
            };：匿名类的类体结束，; 必须要加，因为 new StudentRule(){...} 整体是一个表达式
         */


        /*
        传统写法
        public class AdultRuleImpl implements StudentRule {
            @Override
            public boolean test(Student student) {
                return student.getAge() >= 18;
            }
        }
        StudentRule adultRule = new AdultRuleImpl();
         */

        Student stu = new Student("1001","silas",15,"China");
        System.out.println(adultRule.test(stu));
    }
}
