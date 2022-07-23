package com.ark.base.spring.postprocessor;

import com.ark.base.spring.order.ArkPriorityOrderedFirstHandle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @Classname ArkBeanFactoryPostProcessor
 * @Description TODO
 * @Date 2022/6/30 9:44
 * @Created by hang.li
 */
@Slf4j
@Component
public class ArkDestructionAwareBeanPostProcessor implements DestructionAwareBeanPostProcessor, ArkPriorityOrderedFirstHandle {
    @Override
    public void postProcessBeforeDestruction(Object bean, String beanName) throws BeansException {
        log.info("{} 对象，{} 类实例被销毁之前", beanName, bean.getClass());
    }

    @Override
    public boolean requiresDestruction(Object bean) {
//        log.info("{} 对象创建时，检查对象是否具有销毁前的后置方法", bean.getClass());
        return DestructionAwareBeanPostProcessor.super.requiresDestruction(bean);
    }
}
