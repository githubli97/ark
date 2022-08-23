package com.ark.base.myspringtest.aop.proxy;

import org.springframework.cglib.proxy.*;

import java.lang.reflect.Method;

public class CglibProxyDefaultEchoService {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(NoImplementsEchoServiceImpl.class);
        enhancer.setCallback(new MethodInterceptor() {

            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.print("[CglibProxyDefaultEchoService] ");
                return methodProxy.invokeSuper(o, objects);
            }
        });

//        enhancer.setCallbackFilter(new CallbackFilter() {
//            @Override
//            public int accept(Method method) {
//
//                return "print".equals(method.getName()) ? 0 : 1;
//            }
//        });

        NoImplementsEchoServiceImpl echoService = (NoImplementsEchoServiceImpl) enhancer.create();
        echoService.print("hello world");
    }
}