package com.ark.spring.aop.reflection;


import com.ark.spring.aop.proxy.NoImplementsEchoServiceImpl;
import org.springframework.util.ReflectionUtils;

/**
 * @Classname SpringReflectionUtils
 * @Description TODO
 * @Date 2022/8/24 9:51
 * @Created by hang.li
 */
public class SpringReflectionUtils {
    public static void main(String[] args) {
        ReflectionUtils.doWithMethods(NoImplementsEchoServiceImpl.class,
                method -> System.out.println("[SpringReflectionUtils] " + method),
                method ->
                        method.getParameterCount() == 2
                                && method.getReturnType().equals(void.class));
    }
}
