package com.Silas.API.String;

public class ArrayToString {
    public static String arrToString(int[] arr){
        if(arr == null) return "";
        if(arr.length == 0) return "[]";
        String result = "[";
        for (int i = 0; i < arr.length; i++) {
            if(i == arr.length-1) result = result+arr[i]+']';
            else result = result + arr[i]+',';
        }
        return result;
    }

    static void main() {
        int[] arr = {1,2,3};
        System.out.println(arrToString(arr));
    }
}
