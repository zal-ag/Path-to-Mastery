package com.Silas.DynamicProxy;

public class Test {
    static void main(String[] args) {
        Client client = new Client("aaa");
        Middleware middleware = ProxyForClient.createProxy(client);

        String result = middleware.sing("seventeen");
        System.out.println(result);

        middleware.dance();
    }
}
