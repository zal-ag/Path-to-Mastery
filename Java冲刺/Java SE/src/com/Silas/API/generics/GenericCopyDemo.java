package com.Silas.API.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericCopyDemo {
    static void main() {
        List<Integer> source1 = new ArrayList<>(Arrays.asList(1,2,3));
        List<Number> target1 = new ArrayList<>(Arrays.asList(0.5));

        List<String> source2 = new ArrayList<>(Arrays.asList("Alice","Bob"));
        List<Object> target2 = new ArrayList<>(Arrays.asList(100));

        ListTools.copyInto(source1,target1);
        ListTools.copyInto(source2,target2);
        System.out.println(target1);
        System.out.println(target2);
    }
}
