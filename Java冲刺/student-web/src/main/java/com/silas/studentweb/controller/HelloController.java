package com.silas.studentweb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
// 处理HTTP请求的控制器，方法返回值可写入响应体
public class HelloController {

    @GetMapping("/hello")
    // 将 GET 请求 /hello 映射到该方法
    public String hello() {
        return "Hello HTTP";
    }

    @PostMapping("/echo")
    public String echo(@RequestBody String text) {
        return text;
    }

}
