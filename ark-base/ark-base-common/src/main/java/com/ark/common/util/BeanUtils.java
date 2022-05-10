package com.ark.common.util;

import com.ark.common.exception.ArkRuntimeException;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

public final class BeanUtils {
    private BeanUtils() {
    }

    /**
     * 给指定对象赋值
     *
     * @param bean      依赖对象
     * @param fieldName 设置属性名称
     * @param depend    被依赖对象
     * @throws Exception 赋值查找属性过程中遇到问题
     */
    public static void setProperty(Object bean, String fieldName, Object depend) throws Exception {
        Class<?> beanClass = bean.getClass();
        while (Objects.nonNull(beanClass)) {
            Field[] declaredFields = beanClass.getDeclaredFields();
            for (Field declaredField : declaredFields) {
                if (declaredField.getName().equals(fieldName)) {
                    ReflectionUtils.makeAccessible(declaredField);
                    declaredField.set(bean, depend);
                    return;
                }
            }
            beanClass = beanClass.getSuperclass();
        }
    }

    /**
     * 属性拷贝
     * todo: 这里还有问题！！！
     */
    public static void copyProperties(Object source, Object target)  {
        try {
            org.apache.commons.beanutils.BeanUtils.copyProperties(source, target);
        } catch (Exception e) {
            throw new ArkRuntimeException("拷贝属性失败");
        }
    }
}
