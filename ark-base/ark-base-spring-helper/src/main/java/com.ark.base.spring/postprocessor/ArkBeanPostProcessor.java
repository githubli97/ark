package com.ark.base.spring.postprocessor;

import com.ark.base.spring.order.ArkPriorityOrderedFirstHandle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @Classname ArkBeanFactoryPostProcessor
 * @Description TODO
 * @Date 2022/6/30 9:44
 * @Created by hang.li
 */
@Slf4j
@Component
public class ArkBeanPostProcessor implements BeanPostProcessor, ArkPriorityOrderedFirstHandle {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info("{}类，{} 对象初始化前执行", beanName, bean.getClass());
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("{}类，{} 对象初始化后执行", beanName, bean.getClass());
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
