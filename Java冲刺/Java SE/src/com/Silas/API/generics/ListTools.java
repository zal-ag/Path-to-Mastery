package com.Silas.API.generics;

import java.util.List;

public class ListTools {
    public static <T> T first(List<T> list){
        if(list.isEmpty()) return null;
        return list.getFirst();
    }
    public static void printAll(List<?> list){
        for(Object value : list){
            System.out.println(value);
        }
    }
    public static double sum(List<? extends Number> numbers) {
        double sum = 0;
        for(Number value : numbers){
            double number = value.doubleValue();
            sum += number;
        }
        return sum;
    }
    public static <T> void copyInto(
            List<? extends T> source, List<? super T> target){
        for(T element : source){
            target.add(element);
        }
    }
}
