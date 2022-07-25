package com.ark.base.spring.scope;

import com.ark.ApplicationTest;
import com.ark.base.spring.aware.ArkApplicationContextAware;
import org.junit.Test;

public class ArkThreadScopeTest extends ApplicationTest {

    @Test
    public void get() {
        ArkThreadScopeBean arkThreadScopeBean = ArkApplicationContextAware.applicationContext.getBean("arkThreadScopeBean", ArkThreadScopeBean.class);
        arkThreadScopeBean.printThreadNameProperties();

        Thread thread = new Thread(() -> {
            ArkThreadScopeBean arkThreadScopeBean1 = ArkApplicationContextAware.applicationContext.getBean("arkThreadScopeBean", ArkThreadScopeBean.class);
            arkThreadScopeBean1.printThreadNameProperties();

            ArkThreadScopeBean arkThreadScopeBean2 = ArkApplicationContextAware.applicationContext.getBean("arkThreadScopeBean", ArkThreadScopeBean.class);
            arkThreadScopeBean2.printThreadNameProperties();
        });
        thread.start();
    }
}
