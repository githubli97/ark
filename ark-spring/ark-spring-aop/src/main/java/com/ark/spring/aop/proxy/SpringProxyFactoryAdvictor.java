package com.ark.spring.aop.proxy;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

import java.lang.reflect.Method;

/**
 * @Classname SpringProxyFactory
 * @Description TODO
 * @Date 2022/8/24 11:04
 * @Created by hang.li
 */
public class SpringProxyFactoryAdvictor {

    public static void main(String[] args) throws Exception {
        ProxyFactory proxyFactory = new ProxyFactory(new DefaultEchoServiceImpl());
        proxyFactory.addAdvisor(new DefaultPointcutAdvisor(new SpringProxyFactoryPointcut(), new ThrowsAdviceImpl()));
        EchoService proxy = (EchoService) proxyFactory.getProxy();
        proxy.printRandomException("hello world");
    }
}
