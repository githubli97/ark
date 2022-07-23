package com.ark.base.spring.scope;

import com.ark.ApplicationTest;
import com.ark.base.spring.aware.ArkApplicationContextAware;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ArkThreadScopeTest extends ApplicationTest {
    @Autowired
    private ArkThreadScopeBean arkThreadScopeBean;

    @Test
    public void get() {
        ArkThreadScopeBean arkThreadScopeBean = ArkApplicationContextAware.applicationContext.getBean("arkThreadScopeBean", ArkThreadScopeBean.class);
        arkThreadScopeBean.printThreadNameProperties();

        Thread thread = new Thread(() -> {
            ArkThreadScopeBean arkThreadScopeBean1 = ArkApplicationContextAware.applicationContext.getBean("arkThreadScopeBean", ArkThreadScopeBean.class);
            arkThreadScopeBean1.printThreadNameProperties();
        });
        thread.start();
    }
}
