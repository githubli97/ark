package com.ark.base.spring.scope;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class ArkThreadScope implements Scope {
    public static final String SCOPE_NAME = "arkThread";
    private static ThreadLocal<ConcurrentHashMap<String, Object>> BEANNAME_AND_BEAN = ThreadLocal.withInitial(() -> new ConcurrentHashMap<>());

    public Object get(String name, ObjectFactory<?> objectFactory) {
        Object scopedObject = BEANNAME_AND_BEAN.get().get(name);
        if (scopedObject == null) {
            scopedObject = objectFactory.getObject();
            BEANNAME_AND_BEAN.get().put(name, scopedObject);
            Object retrievedObject = BEANNAME_AND_BEAN.get().get(name);
            if (retrievedObject != null) {
                scopedObject = retrievedObject;
            }
            return scopedObject;
        }
        return null;
    }

    @Nullable
    public Object remove(String name) {
        Object scopedObject = BEANNAME_AND_BEAN.get().get(name);

        if (scopedObject != null) {
            BEANNAME_AND_BEAN.get().remove(name);
            return scopedObject;
        } else {
            return null;
        }
    }

    public void registerDestructionCallback(String name, Runnable callback) {
        log.info("registerDestructionCallback， name: {}", name);
    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}
