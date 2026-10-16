package com.Silas.API.Wrapper;

public class wrapperTest1 {
    static void main() {
        // int -> Integer
        int n = 100;
        // 通过 new 操作符创建，已弃用
        Integer i1 = new Integer(n);
        // 通过静态方法 valueOf(int) 创建实例
        Integer i2 = Integer.valueOf(n);
        // 通过静态方法 valueOf(String) 创建实例
        Integer i3 = Integer.valueOf("100");

        // Integer -> int
        int m = i2.intValue();

        // 去除不必要的装箱和拆箱
        Integer integer = 100; // 编译器自动使用 Integer.valueOf(int)
        int num = integer; // 编译器自动使用 Integer.intValue()

        // 自动拆箱异常
        try{
            Integer x = null;
            int y = x;
        }catch(NullPointerException e){
            System.out.println(e.getMessage());
        }

        // 比较
        Integer i4 = 127;
        Integer i5 = 127;
        Integer i6 = 9999;
        Integer i7 = 9999;
        System.out.println(i4 == i4);
        System.out.println(i6 == i7);
        System.out.println(i4.equals(i5));
        System.out.println(i6.equals(i7));

        // 进制转换
        int num1 = Integer.parseInt("64");
        int num2 = Integer.parseInt("64",16);
        System.out.println(num1);

        System.out.println(Integer.toString(100));
        System.out.println(Integer.toString(100,36));
        System.out.println(Integer.toHexString(100));
        System.out.println(Integer.toOctalString(100));
        System.out.println(Integer.toBinaryString(100));

        // 常用静态变量
        Boolean t = Boolean.TRUE;
        Boolean f = Boolean.FALSE;
        System.out.println(t);
        System.out.println(f);

        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        System.out.println(max);
        System.out.println(min);

        int sizeOfLong = Long.SIZE;
        int byteOfLong = Long.BYTES;
        System.out.println(sizeOfLong);
        System.out.println(byteOfLong);

        // 处理无符号整形
        byte b1 = -1;
        byte b2 = 127;
        System.out.println(Byte.toUnsignedInt(b1));
        System.out.println(Byte.toUnsignedInt(b2));

        int i8 = -1;
        System.out.println(Integer.toUnsignedLong(i8));

        // 父类Number
        Number number = new Integer(999);
        byte b = number.byteValue();
        short s = number.shortValue();
        int i9 = number.intValue();
        long l = number.longValue();
        float f1 = number.floatValue();
        double d = number.doubleValue();



    }
}
