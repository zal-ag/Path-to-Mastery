package com.Silas.oop.advanced.test4;

public enum OrderState {
    PAYMENT_PENDING("待支付"),
    PROCESSING("处理中"),
    SHIPPED("已发货"),
    OUT_FOR_DELIVERY("配送中"),
    DELIVERED("已送达"),
    CANCELED("已取消");

    private String name;

    OrderState() {
    }

    OrderState(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
