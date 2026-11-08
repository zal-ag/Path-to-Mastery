package com.Silas.API.Object.CloneTest;

public class User implements Cloneable{
    private String id;

    public User(String id) {
        this.id = id;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
