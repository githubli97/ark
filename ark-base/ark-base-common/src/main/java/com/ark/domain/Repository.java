package com.ark.domain;

/**
 * Repository父类, 定义一些公共的方法.
 *
 * @param <E> 实体
 */
public interface Repository<E extends AbstractEntity> {

  E store(E entity);
}
