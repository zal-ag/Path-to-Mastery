package com.Silas.API.collection;

import java.util.HashSet;
import java.util.Set;

public class HashSetDedupDEmo {
    static void main() {
        Set<String> nameSet = new HashSet<>();
        System.out.println(nameSet.add("Alice"));
        System.out.println(nameSet.add("Bob"));
        System.out.println(nameSet.add("Alice"));
        System.out.println(nameSet.add("Carol"));
        System.out.println(nameSet.add("Bob"));
        System.out.println(nameSet.size());
        for(String name : nameSet){
            System.out.println(name);
        }
    }
}
