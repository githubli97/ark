package com.ark.base.domain.base;


import com.ark.base.domain.trace.BaseTrace;

/**
 * 实体继承的公共类
 * 实现了基础的数据追踪
 * 校验领域实体是否一致方法
 */
public abstract class ArkEntity<T> extends BaseTrace {
    public abstract boolean sameIdentityAs(T other);
}
