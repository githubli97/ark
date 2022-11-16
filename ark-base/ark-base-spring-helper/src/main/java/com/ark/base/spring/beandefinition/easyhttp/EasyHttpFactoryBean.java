package com.ark.base.spring.beandefinition.easyhttp;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.Proxy;

/**
 * @Classname EasyHttpFactoryBean
 * @Description TODO
 * @Date 2022/6/30 9:44
 * @Created by hang.li
 */
@Slf4j
@Data
public class EasyHttpFactoryBean<T> implements FactoryBean<T> {
    public OkHttpClient httpClient;
    /**
     * The interface class of the reference service
     */
    private Class<T> interfaceClass;

    public EasyHttpFactoryBean(Class<T> interfaceClass) {
        this.interfaceClass = interfaceClass;
    }

    @Override
    public T getObject() throws Exception {
        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[] { interfaceClass }, new EasyHttpProxy<T>(httpClient, interfaceClass));
    }

    @Override
    public Class<T> getObjectType() {
        return getInterfaceClass();
    }
}
