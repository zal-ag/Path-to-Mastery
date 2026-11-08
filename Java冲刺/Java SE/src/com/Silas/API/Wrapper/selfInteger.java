package com.Silas.API.Wrapper;

public class selfInteger {
    static void main() {

        myInteger i = new myInteger(999);
        //
        int n = i.intValue();
    }
}
// 自定义包装类（只包含一个实例字段 int1）
class myInteger{
    private final int value;

    // 将 int 基本类型变为一个引用类型 myInteger
    public myInteger(int value) {
        this.value = value;
    }

    // 将 myInteger 转回 int
    public int intValue(){
        return this.value;
    }
}
