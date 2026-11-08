package com.Silas.DynamicProxy;

public class Client implements Middleware{
    public String name;

    public Client(String name) {
        this.name = name;
    }

    @Override
    public String sing(String name) {
        System.out.println(this.name+"开始唱"+name);
        return "谢谢";
    }

    @Override
    public void dance() {
        System.out.println("开始跳舞");
    }
}
