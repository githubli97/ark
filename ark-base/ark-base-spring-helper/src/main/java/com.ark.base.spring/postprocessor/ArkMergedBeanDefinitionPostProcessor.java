package com.ark.base.spring.postprocessor;

import com.ark.base.spring.order.ArkPriorityOrderedFirstHandle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.MergedBeanDefinitionPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * @Classname ArkBeanFactoryPostProcessor
 * @Description 扫描BeanDefinition属性方法，添加到RootBeanDefinition中
 *
 * @see org.springframework.context.annotation.CommonAnnotationBeanPostProcessor
 * @see org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor
 * @Date 2022/6/30 9:44
 * @Created by hang.li
 */
@Slf4j
@Component
public class ArkMergedBeanDefinitionPostProcessor implements MergedBeanDefinitionPostProcessor, ArkPriorityOrderedFirstHandle {

    @Override
    public void postProcessMergedBeanDefinition(RootBeanDefinition beanDefinition, Class<?> beanType, String beanName) {
        log.info("{}， {}，对指定bean的给定合并bean定义进行后期处理", beanType.getName(), beanName);
    }

    @Override
    public void resetBeanDefinition(String beanName) {
        log.info("{}，通知指定名称的bean定义已重置，并且该后处理器应清除受影响bean的任何元数据。", beanName);
        MergedBeanDefinitionPostProcessor.super.resetBeanDefinition(beanName);
    }
}
