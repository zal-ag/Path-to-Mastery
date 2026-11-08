package com.Silas.API.ArrayList.BasicDemo4;

import java.util.ArrayList;

public class Demo4 {
    public static boolean check(ArrayList<User> list,int id){
        boolean sign = false;
        for (int i = 0; i < list.size(); i++) {
            User u = list.get(i);
            if(u.getId() == id) {
                sign = true;
                break;
            }
        }
        return sign;
    }
    static void main() {
        ArrayList<User> list = new ArrayList<>();

        list.add(new User(1,"Silas",123456));
        list.add(new User(2,"Sheng",456789));
        list.add(new User(3,"Yinuo",789123));

        System.out.println(check(list,1));
        System.out.println(check(list,9));

    }
}
