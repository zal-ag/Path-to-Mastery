package com.Silas.API.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorRemoveDemo {
    static void main() {
        List<String> list = new ArrayList<>();
        list.add("Alice");
        list.add("Bob");
        list.add("Ben");
        list.add("Carol");
        list.add("Bill");
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            String name = iterator.next();
            if(name.startsWith("B")){
                iterator.remove();
            }
        }
        System.out.println(list);
    }
}
