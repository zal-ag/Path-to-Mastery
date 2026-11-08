package com.Silas.API.ArrayList;

import java.util.ArrayList;
import java.util.Arrays;

public class BasicDemo1 {
    static void main() {
        // 存放的是Integer对象，int的包装类
        ArrayList<Integer> numbers = new ArrayList<>(
                Arrays.asList(1,2,1,3));
        numbers.remove(1);
        numbers.remove(Integer.valueOf(1)); // 得到的是Integer对象
        System.out.println(numbers);
    }

}
