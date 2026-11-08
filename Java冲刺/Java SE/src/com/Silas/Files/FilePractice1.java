package com.Silas.Files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FilePractice1 {
    static void main() {
        Path path = Path.of("study-node.txt");
        System.out.println("文件的绝对路径：" + path.toAbsolutePath());
        try{
            Files.writeString(path,"\n完成追加写练习", StandardOpenOption.APPEND);
            String text = Files.readString(path);
            System.out.println(text);
        }catch(IOException e){
            System.out.println("操作失败"+e.getMessage());
        }
    }
}
