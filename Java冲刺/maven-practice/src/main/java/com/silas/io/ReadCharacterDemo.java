package com.silas.io;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReadCharacterDemo {
    static void main() {
        Path path = Path.of("target/read-character-demo.txt");
        try{
            Files.writeString(path,"A中B", StandardCharsets.UTF_8);
            System.out.println("写入成功");
            try(Reader reader = Files.newBufferedReader(path,StandardCharsets.UTF_8)){
                int value = reader.read();
                while(value != -1){
                    System.out.println((char)value);
                    value = reader.read();
                }
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
