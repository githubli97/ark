package com.ark.base.spring.aware;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.FactoryBean;

/**
 * @Classname ArkApplicationContextAware
 * @Description TODO
 * @Date 2022/6/30 9:44
 * @Created by hang.li
 */
@Slf4j
@Data
public class ArkFactoryBean<T> implements FactoryBean<T> {
    /**
     * The interface class of the reference service
     */
    private Class<?> interfaceClass;

    @Override
    public T getObject() throws Exception {
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return getInterfaceClass();
    }
}
