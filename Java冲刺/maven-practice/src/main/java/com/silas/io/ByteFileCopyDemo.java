package com.silas.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class ByteFileCopyDemo {
    static void main() {
        Path source = Path.of("target","copy-source.txt");
        Path target = Path.of("target","copy-result.txt");

        try{
            Files.writeString(source,"ABCDE");
            copyFile(source,target);
            String content = Files.readString(target);
            System.out.println(content);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void copyFile(Path source,Path target) throws IOException {
        try(
                InputStream input = Files.newInputStream(source);
                OutputStream output = Files.newOutputStream(target)
        ) {
            byte[] buffer = new byte[2];
            int count = input.read(buffer);

            while(count != -1){
                output.write(buffer,0,count);
                count = input.read(buffer);
            }
        }
    }
}
