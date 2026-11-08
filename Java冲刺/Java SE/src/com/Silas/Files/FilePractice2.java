package com.Silas.Files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;

public class FilePractice2 {
    static void main() {
        StringBuilder builder = new StringBuilder();
        ArrayList<String> arr = new ArrayList<>(Arrays.asList(
                "完成异常处理练习\n",
                "完成文件读写练习\n",
                "完成追加写入练习"));
        for(String record : arr) builder.append(record);
        Path path = Path.of("study-records.txt");
        try{
            Files.writeString(path,builder.toString());
            String content = Files.readString(path);
            System.out.println(content);
        }catch(IOException e){
            System.out.println("操作失败：" + e.getMessage());
        }
    }
}
