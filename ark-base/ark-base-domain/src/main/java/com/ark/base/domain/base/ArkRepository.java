package com.ark.base.domain.base;

public interface ArkRepository<T extends ArkEntity> {
    T store(T entiy);
}
