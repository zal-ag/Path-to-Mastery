package com.Silas.oop.advanced.InnerClass;

public class Outer {
    private final String name = "外部对象";
    private static final String school = "Java学校";
    // 【成员内部类】
    public class Inner1 {
        private final String name = "内部对象";
        public void show() {
            System.out.println(name);
            System.out.println(this.name); // this 表示内部对象
            // 这个 Outer 是 Java关键字，指的是外部类
            System.out.println(Outer.this.name); // Outer.this 表示关联的外部对象
        }
    }

    // 【静态内部类】
    public static class Inner2 {
        public void show() {
            System.out.println(school);
        }
        public void showOuter(Outer outer) {
            System.out.println(outer.name);
        }
    }

    // 【局部内部类】
    public void show() {
        String message = "学习Python";
        // 类定义在成员方法中
        class Printer {
            public void print() {
                // 局部内部类的方法只在相应作用域可用，也就是 show() 内部
                System.out.println(message);
            }
        }

        Printer printer = new Printer();
        printer.print();
    }
}
