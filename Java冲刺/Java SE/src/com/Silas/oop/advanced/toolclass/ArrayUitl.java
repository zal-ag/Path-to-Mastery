package com.Silas.oop.advanced.toolclass;

import org.w3c.dom.ls.LSOutput;

public class ArrayUitl {
    // 私有化构造方法，目的：不让外界创造对象
    private ArrayUitl(){}

    // 方法定义为静态
    public static void printArr(int[] arr){
        System.out.print("[");
        for (int i = 0; i < arr.length; i++){
            if(i == arr.length-1){
                System.out.println(arr[i]+"]");
            }else {
                System.out.print(arr[i] + ",");
            }
        }
    }
    public static double getAverage(int[] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        double avg = sum*1.0 / arr.length;
        return avg;
    }
}
