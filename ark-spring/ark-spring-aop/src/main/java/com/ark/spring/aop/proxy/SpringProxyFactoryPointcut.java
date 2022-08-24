package com.ark.spring.aop.proxy;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

import java.lang.reflect.Method;

/**
 * @Classname SpringProxyFactory
 * @Description TODO
 * @Date 2022/8/24 11:04
 * @Created by hang.li
 */
public class SpringProxyFactoryPointcut implements Pointcut {
    @Override
    public ClassFilter getClassFilter() {

        return new ClassFilter() {
            @Override
            public boolean matches(Class<?> clazz) {
                if (EchoService.class.isAssignableFrom(clazz)) {
                    return true;
                }
                return false;
            }
        };
    }

    @Override
    public MethodMatcher getMethodMatcher() {
        return new MethodMatcher() {
            @Override
            public boolean matches(Method method, Class<?> targetClass) {
                return true;
            }

            @Override
            public boolean isRuntime() {
                return false;
            }

            @Override
            public boolean matches(Method method, Class<?> targetClass, Object... args) {
                return false;
            }
        };
    }
}
