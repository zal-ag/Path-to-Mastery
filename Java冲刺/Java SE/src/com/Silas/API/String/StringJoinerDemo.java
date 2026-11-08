package com.Silas.API.String;

import java.util.StringJoiner;

public class StringJoinerDemo {
    static void main() {
        StringJoiner sj1 = new StringJoiner(",");
        sj1.add("1").add("2").add("3");
        System.out.println(sj1);

        StringJoiner sj2 = new StringJoiner("---","[","]");
        sj2.add("aaa").add("bbb").add("ccc").toString();
        System.out.println(sj2);
        System.out.println(sj2.length());
    }
}
