package com.silas.jdbc;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class PropertiesReadDemo {
    static void main() {
        Properties properties = new Properties();
        Path path = Path.of("app-demo.properties");
        try(Reader reader = Files.newBufferedReader(path,StandardCharsets.UTF_8)){
            properties.load(reader);
            String name = properties.getProperty("app.name");
            String pageSizeText = properties.getProperty("app.pageSize");
            int pageSize = Integer.parseInt(pageSizeText);
            System.out.println(name);
            System.out.println(pageSize+1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
