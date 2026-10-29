package com.silas.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReadLineDemo {
    static void main() {
        Path path = Path.of("target","read-line-demo");
        try{
            Files.writeString(path,"1001,张三,20,北京\n\n1002,李四,19,上海", StandardCharsets.UTF_8);
            try(BufferedReader reader = Files.newBufferedReader(path,StandardCharsets.UTF_8)){
                String line = reader.readLine();
                int count = 0;
                while(line != null){
                    count++;
                    System.out.println("第"+count+"行："+"["+line+"]");
                    line = reader.readLine();
                }
            }
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
