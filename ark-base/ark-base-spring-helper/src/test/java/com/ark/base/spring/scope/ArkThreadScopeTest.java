package com.ark.base.spring.scope;

import com.ark.ApplicationTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ArkThreadScopeTest extends ApplicationTest {
    @Autowired
    private ArkThreadScopeBean arkThreadScopeBean;

    /**
     * 如果在scope上设置了proxyMode为TARGET_CLASS，
     * 成员变量arkThreadTargetClassScopeBean在不同的scope下就是不同的对象
     */
    @Autowired
    private ArkThreadTargetClassScopeBean arkThreadTargetClassScopeBean;

    @Test
    public void get() {
        arkThreadScopeBean.printThreadNameProperties();
        arkThreadTargetClassScopeBean.printThreadNameProperties();

        Thread thread = new Thread(() -> {
            arkThreadScopeBean.printThreadNameProperties();
            arkThreadTargetClassScopeBean.printThreadNameProperties();
        });
        thread.start();
    }
}
