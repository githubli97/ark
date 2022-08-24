package com.ark.spring.aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkDynamicProxyDefaultEchoService {
    public static void main(String[] args) {
        EchoService echoService = (EchoService) Proxy.newProxyInstance(DefaultEchoServiceImpl.class.getClassLoader(),
                DefaultEchoServiceImpl.class.getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object o, Method method, Object[] args) {
                        if (method.getName().equals("print")) {
                            System.out.printf("[JdkDynamicProxyDefaultEchoService] ");
                        }
                        try {
                            return method.invoke(new DefaultEchoServiceImpl(), args);
                        } catch (Exception e) {

                        } finally {
                        }
                        return null;
                    }
        });
        echoService.print("hello world");
    }
}