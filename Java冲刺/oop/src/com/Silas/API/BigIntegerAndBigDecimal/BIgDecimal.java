package com.Silas.API.BigIntegerAndBigDecimal;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static java.math.RoundingMode.*;

public class BIgDecimal {
    static void main() {

        System.out.println(0.01);
        System.out.println(0.09);
        System.out.println(0.01+0.09);

        BigDecimal bd1 = new BigDecimal(0.1);
        BigDecimal bd2 = new BigDecimal(0.9);
        System.out.println(bd1);
        System.out.println(bd2);
        System.out.println(bd1.add(bd2));

        BigDecimal bd3 = new BigDecimal("0.01");
        BigDecimal bd4 = new BigDecimal("0.09");
        System.out.println(bd3);
        System.out.println(bd4);
        System.out.println(bd3.add(bd4));

        BigDecimal bd5 = BigDecimal.valueOf(10);
        BigDecimal bd6 = BigDecimal.valueOf(3);

        System.out.println(bd5.divide(bd6,2, HALF_UP));

        BigDecimal b1 = new BigDecimal("0.226");
        BigDecimal b2 = new BigDecimal("123.226");
        BigDecimal b3 = new BigDecimal("-1.226");



    }
}
