package com.ark.domain;

public interface IRepository<E extends AbstractEntity> {
    void store(E entity);
}
