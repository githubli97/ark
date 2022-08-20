package com.ark.base.spring.aware;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @Classname ArkEnvironmentAware
 * @Description TODO
 * @Date 2022/6/30 9:44
 * @Created by hang.li
 */
@Slf4j
@Component
public class ArkEnvironmentAware implements EnvironmentAware {
    public static volatile Environment environment;

    @Override
    public void setEnvironment(Environment environment) {
        log.info("织入environment");
        ArkEnvironmentAware.environment = environment;
    }
}
