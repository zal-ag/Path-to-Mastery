package com.silas.io;

import java.nio.charset.StandardCharsets;

public class CharsetDemo {
    static void main() {
        String[] text = {"ABC","中文","A中B"};
        for(String str : text){
            byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
            System.out.println(bytes.length);
            String restored = new String(bytes,StandardCharsets.UTF_8);
            System.out.println(restored);
        }
    }
}
