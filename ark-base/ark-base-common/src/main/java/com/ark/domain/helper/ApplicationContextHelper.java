package com.ark.domain.helper;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * ApplicationContextHelper
 *
 * @author Frank Zhang
 * @date 2020-11-14 1:58 PM
 */
@Component
public class ApplicationContextHelper {
    private static final ApplicationContext applicationContext = ArkApplicationContextAware.applicationContext;

    public static <T> T getBean(Class<T> targetClz) {
        T beanInstance = null;
        //优先按type查
        try {
            beanInstance = applicationContext.getBean(targetClz);
        } catch (Exception e) {
        }
        //按name查
        if (beanInstance == null) {
            String simpleName = targetClz.getSimpleName();
            //首字母小写
            simpleName = Character.toLowerCase(simpleName.charAt(0)) + simpleName.substring(1);
            beanInstance = applicationContext.getBean(simpleName, targetClz);
        }
        if (beanInstance == null) {
            throw new RuntimeException("Component " + targetClz + " can not be found in Spring Container");
        }
        return beanInstance;
    }

    public static Object getBean(String claz) {
        return ApplicationContextHelper.applicationContext.getBean(claz);
    }

    public static <T> T getBean(String name, Class<T> requiredType) {
        return ApplicationContextHelper.applicationContext.getBean(name, requiredType);
    }

    public static <T> T getBean(Class<T> requiredType, Object... params) {
        return ApplicationContextHelper.applicationContext.getBean(requiredType, params);
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }
}
