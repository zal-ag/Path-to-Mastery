package com.silas.io;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileResourceDemo {
    static void main() {
        Path path = Path.of("pom.xml");
        try(InputStream input = Files.newInputStream(path)) {
            System.out.println("文件已打开");
        }catch (IOException e){
            System.out.println("文件操作失败：" + e.getMessage());
        }
        System.out.println("本次操作结束");
    }
}
