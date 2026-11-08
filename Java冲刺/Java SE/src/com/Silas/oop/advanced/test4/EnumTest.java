package com.Silas.oop.advanced.test4;

public class EnumTest {
    static void main() {
       OrderState o1 = OrderState.PAYMENT_PENDING;
       System.out.println(o1.getName());
       OrderState[] arr = OrderState.values();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        OrderState shipped = OrderState.valueOf("SHIPPED");
        System.out.println(shipped);
    }
}
