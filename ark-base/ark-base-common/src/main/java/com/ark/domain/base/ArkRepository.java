package com.ark.domain.base;

public interface ArkRepository<T extends ArkEntity> {
    T store(T entiy);
}
