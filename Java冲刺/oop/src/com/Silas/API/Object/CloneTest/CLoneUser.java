package com.Silas.API.Object.CloneTest;

public class CLoneUser {
    static void main() throws CloneNotSupportedException {
        User u1 = new User("001");
        Object u2 =  u1.clone();
        User u3 = (User) u1.clone();
    }
}
