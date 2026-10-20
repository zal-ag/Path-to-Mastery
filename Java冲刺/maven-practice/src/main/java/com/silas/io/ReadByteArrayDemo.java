package com.silas.io;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReadByteArrayDemo {
    static void main() {
        Path file = Path.of("target","read-byte-demo.txt");
        byte[] buffer = new byte[2];
        try{
            Files.writeString(file,"ABCDE");
            try(InputStream input = Files.newInputStream(file)){
                int count = input.read(buffer);
                while(count != -1){
                    System.out.println("本次读取数量：" + count);
                    for(int i = 0; i < count; i++){
                        System.out.println(buffer[i]);
                    }
                    count = input.read(buffer);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
