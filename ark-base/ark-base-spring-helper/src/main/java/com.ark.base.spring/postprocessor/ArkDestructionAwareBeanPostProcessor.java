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
        log.info("{}类，{} 对象实例被销毁之前", beanName, bean.getClass());
    }

    @Override
    public boolean requiresDestruction(Object bean) {
        log.info("{} 类实例被销毁之前，判断是否进入当前逻辑", bean.getClass());
        return DestructionAwareBeanPostProcessor.super.requiresDestruction(bean);
    }
}
