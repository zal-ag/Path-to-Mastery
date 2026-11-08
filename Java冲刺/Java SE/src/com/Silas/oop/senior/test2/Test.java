package com.Silas.oop.senior.test2;

public class Test {
    static void main() {

       Android a = new Android();
       a.brand = "华为";
       a.price = 5999;
       System.out.println(a.brand+" "+a.price);
       a.call();
       a.sendMessage();
       a.NFC();

       IOS i = new IOS();
       i.brand = "iphone 18 promax";
       i.price = 9999;
       System.out.println(i.brand+" "+i.price);
       i.call();
        i.sendMessage();

        Laptop l = new Laptop();
        l.brand = "Rog";
        l.price = 15999;
        System.out.println(l.brand+" "+l.price);
        l.Code();
    }
}
