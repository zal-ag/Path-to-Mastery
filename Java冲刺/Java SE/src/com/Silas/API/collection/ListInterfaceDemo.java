package com.Silas.API.collection;

import java.util.ArrayList;
import java.util.List;

public class ListInterfaceDemo {
    static void main() {
        List<String> nameList = new ArrayList<>();
        nameList.add("Alice");
        nameList.add("Bob");
        nameList.add("Carol");
        printNames(nameList);
    }
    static void printNames(List<String> names){
        for(String name : names){
            System.out.println(name);
        }
    }
}
