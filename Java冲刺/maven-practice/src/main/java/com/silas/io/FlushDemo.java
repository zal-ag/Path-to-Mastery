package com.silas.io;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FlushDemo {
    static void main() {
        Path path = Path.of("target","flush-demo.txt");
        try{
            try(BufferedWriter writer = Files.newBufferedWriter(path)){
                writer.write("第一段");
                writer.flush();
                String content = Files.readString(path);
                System.out.println(content);
                writer.write("第二段");
            }
            String content = Files.readString(path);
            System.out.println(content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
