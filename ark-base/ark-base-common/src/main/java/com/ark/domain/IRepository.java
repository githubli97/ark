package com.ark.domain;

public interface IRepository<E extends AbstractEntity> {

    E store(E entity);
}
