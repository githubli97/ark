package com.ark.base.spring.postprocessor;

import com.ark.base.spring.order.ArkPriorityOrderedFirstHandle;
import com.ark.base.spring.scope.ArkThreadScope;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
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
public class ArkBeanFactoryPostProcessor implements BeanFactoryPostProcessor, ArkPriorityOrderedFirstHandle {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        log.info("在标准初始化之后，修改应用程序上下文的内部bean工厂。 所有bean定义都已加载，但还没有实例化任何bean。 这就允许覆盖或添加属性，甚至可以向预先初始化bean添加属性。");
        beanFactory.registerScope(ArkThreadScope.SCOPE_NAME, new ArkThreadScope());
    }
}
