package com.Silas.Files;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.nio.file.Files;

public class FilePractice3 {
    static void main() {
        Path path = Path.of("study-records.txt");
        try{
            ArrayList<String> list = new ArrayList<>(Files.readAllLines(path));
            if(list.isEmpty()) System.out.println("暂无学习记录");
            else{
                System.out.printf("共%d条学习记录%n",list.size());
                for (int i = 0; i < list.size(); i++) {
                    System.out.println(i+1 + ". " + list.get(i));
                }
            }
        }catch(IOException e){
            System.out.println("出现异常" + e.getMessage());
        }
    }
}
