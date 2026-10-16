package com.Silas.API.Object.toStringAndEquals;

public class toStringBook {
    static void main() {
        Book book = new Book("Java入门");
        // 在没有重写toString方法前打印的是类的全限定名@哈希值的十六进制显示
        // com.Silas.API.Object.toStringAndEquals.Book@23fc625e
        System.out.println(book);
        // 重写方法后，得到的就是你想要的字符串

        // 重写equals方法，比较属性值
        Book book1 = new Book("Java入门");
        System.out.println(book.equals(book1));
    }
}
