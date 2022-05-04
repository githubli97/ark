package com.ark.base.domain.base;


import com.ark.base.domain.trace.BaseTrace;

public abstract class ArkEntity<T> extends BaseTrace {
    public abstract boolean sameIdentityAs(T other);
}
