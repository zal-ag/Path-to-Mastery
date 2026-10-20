package com.silas.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ByteFileCopyDemoTest {

    @TempDir
    Path tempDir;

    @Test
    void copiesCompleteContent() throws IOException {
        Path source = tempDir.resolve("source.txt");
        Path target = tempDir.resolve("target.txt");
        Files.writeString(source,"ABCDE");
        ByteFileCopyDemo.copyFile(source,target);
        String content = Files.readString(target);
        Assertions.assertEquals("ABCDE",content);
    }

    @Test
    void copyingEmptyFileClearsTarget() throws IOException {
        Path source = tempDir.resolve("source.txt");
        Path target = tempDir.resolve("target.txt");
        Files.writeString(source,"");
        Files.writeString(target,"旧内容");
        ByteFileCopyDemo.copyFile(source,target);
        String content = Files.readString(target);
        Assertions.assertEquals("",content);
    }
}
