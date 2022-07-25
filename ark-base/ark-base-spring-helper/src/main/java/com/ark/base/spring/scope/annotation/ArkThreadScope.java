package com.ark.base.spring.scope.annotation;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

import static com.ark.base.spring.scope.ArkThreadScope.SCOPE_NAME;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Scope(SCOPE_NAME)
public @interface ArkThreadScope {
}
