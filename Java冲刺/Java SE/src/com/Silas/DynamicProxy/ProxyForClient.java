package com.Silas.DynamicProxy;

/*
    通过该类创建一个代理
 */

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyForClient {

    // 给 Client 对象创建一个代理
    // 参数：需要代理的 Client
    // 返回值：给 Client 创建的代理
    public static Middleware createProxy(Client client) {

       Middleware middleware = (Middleware) Proxy.newProxyInstance(
               ProxyForClient.class.getClassLoader(),    // 参数1 类加载器来加载代理类（这个类必须能加载需要代理的接口）
               new Class<?>[]{Middleware.class}, // 参数2 代理对象需要实现的接口
               new InvocationHandler() { // 参数3 调用处理器
                   @Override
                   public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                       if(method.getName().equals("sing")) System.out.println("准备话筒");
                       else if (method.getName().equals("dance")) System.out.println("准备音乐");
                       return method.invoke(client,args);
                   }
               }
       );
       return middleware;
    }
}
