package com.ark.base.spring.scope;

import lombok.Data;
import lombok.Getter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@Component
@Scope(ArkThreadScope.SCOPE_NAME)
public class ArkThreadScopeBean {
    private final String threadName = Thread.currentThread().getName();

    public void printThreadNameProperties() {
        System.out.println(System.identityHashCode(this));
    }
}
