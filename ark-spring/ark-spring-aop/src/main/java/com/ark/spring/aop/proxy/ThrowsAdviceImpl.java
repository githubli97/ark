package com.ark.spring.aop.proxy;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

public class ThrowsAdviceImpl implements ThrowsAdvice {
    public void afterThrowing(Method method, Object[] args, Object target, Exception ex) {
        System.out.println("[SpringProxyFactory] afterThrowing ");
    }
}