package com.ark.spring.aop.proxy;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.AfterAdvice;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.aop.aspectj.AspectJAroundAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;
import java.util.Random;

/**
 * @Classname SpringProxyFactory
 * @Description TODO
 * @Date 2022/8/24 11:04
 * @Created by hang.li
 */
public class SpringProxyFactoryAdvice {

    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory(new NoImplementsEchoServiceImpl());
        proxyFactory.addAdvice(new MethodBeforeAdvice() {
            @Override
            public void before(Method method, Object[] args, Object target) throws Throwable {
                System.out.println( "[SpringProxyFactoryAdvice] before ");
            }
        });
        proxyFactory.addAdvice(new AfterReturningAdvice() {
            @Override
            public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
                System.out.println( "[SpringProxyFactoryAdvice] afterReturning ");

            }
        });
        proxyFactory.addAdvice(new ThrowsAdviceImpl());
//        proxyFactory.addAdvice(new MethodBeforeAdvice() {
//            @Override
//            public void before(Method method, Object[] args, Object target) throws Throwable {
//                System.out.print( "[SpringProxyFactory] ");
//            }
//        });
        NoImplementsEchoServiceImpl proxy = (NoImplementsEchoServiceImpl) proxyFactory.getProxy();
        proxy.printRandomException("hello world");
    }
}
