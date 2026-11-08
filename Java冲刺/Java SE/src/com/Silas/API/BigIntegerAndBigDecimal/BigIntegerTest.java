package com.Silas.API.BigIntegerAndBigDecimal;

import java.math.BigInteger;

public class BigIntegerTest {
    static void main() {
        BigInteger bi1 = new BigInteger("123456789123456789");
        BigInteger bd1 = BigInteger.valueOf(10);
        BigInteger bd2 = BigInteger.valueOf(3);

        BigInteger[] arr = bd1.divideAndRemainder(bd2);
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(bd1.pow(3));

        int i = bd1.intValue();
        double d = bd1.doubleValue();
        System.out.println(d);
    }

}
