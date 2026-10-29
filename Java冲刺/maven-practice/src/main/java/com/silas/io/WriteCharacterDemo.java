package com.silas.io;

import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriteCharacterDemo {
    static void main() {
        Path path = Path.of("target/write-character-demo.txt");
        try {
            try (Writer writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
                writer.write("学习字符流");
                writer.write("\n");
                writer.write("中文可以直接写入");
            }
            String content = Files.readString(path);
            System.out.println(content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
