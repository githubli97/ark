package com.ark.base.spring.scope;

import com.ark.base.spring.scope.annotation.ArkThreadTargetClassScope;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component
@ArkThreadTargetClassScope
public class ArkThreadTargetClassScopeBean {
    private final String threadName = Thread.currentThread().getName();

    /**
     * 打印当前对象的内存地址
     */
    public void printThreadNameProperties() {
        System.out.println(System.identityHashCode(this));
    }
}
