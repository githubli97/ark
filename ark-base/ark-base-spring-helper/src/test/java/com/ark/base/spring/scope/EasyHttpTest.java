package com.ark.base.spring.scope;

import com.ark.base.spring.beandefinition.ArkBeanDefinitionRegistryPostProcessor;
import com.ark.base.spring.beandefinition.easyhttp.mapper.BingEasyHttp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericApplicationContext;

public class EasyHttpTest {
    private GenericApplicationContext applicationContext;

    @BeforeEach
    void setupContext() {
        applicationContext = new GenericApplicationContext();
        applicationContext.addBeanFactoryPostProcessor(new ArkBeanDefinitionRegistryPostProcessor());
    }
    @Test
    void testInterfaceScan() {
        startContext();
        BingEasyHttp baiduEasyHttp = applicationContext.getBean("bingEasyHttp", BingEasyHttp.class);
        System.out.println(baiduEasyHttp.index());
    }

    private void startContext() {
        applicationContext.refresh();
        applicationContext.start();
    }
}
