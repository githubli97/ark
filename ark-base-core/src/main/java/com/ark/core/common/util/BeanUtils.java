package com.ark.core.common.util;

import com.ark.core.common.exception.ArkRuntimeException;
import java.lang.reflect.Field;
import java.util.Objects;
import org.springframework.util.ReflectionUtils;

/**
 * 封装spring beanUtils.
 */
public final class BeanUtils {

  private BeanUtils() {
  }

  /**
   * 给指定对象赋值.
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
   * 属性拷贝.
   */
  public static <S, T> void copyProperties(S source, T target) {
    try {
      org.springframework.beans.BeanUtils.copyProperties(source, target);
    } catch (Exception e) {
      throw new ArkRuntimeException("拷贝属性失败");
    }
  }
}
