package com.silas.io;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReadByteDemo {
    static void main() {
        Path file = Path.of("target","read-byte-demo.txt");
        try{
            Files.writeString(file,"ABC");
            try(InputStream input = Files.newInputStream(file)){
                int value = input.read();
                while(value != -1){
                    System.out.println(value);
                    value = input.read();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
