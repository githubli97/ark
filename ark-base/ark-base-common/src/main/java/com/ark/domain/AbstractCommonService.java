package com.ark.domain;


import org.springframework.beans.factory.annotation.Autowired;

/**
 * 抽象实体服务,更新状态的方法.
 *
 * @param <E> 实体
 */
public abstract class AbstractCommonService<E extends AbstractCommonEntity> {
  @Autowired
  protected Repository<E> repository;

  /**
   * 禁用实体.
   */
  public void enable(E commonEntity) {
    commonEntity.enable();
    repository.store(commonEntity);
  }

  /**
   * 启用实体.
   */
  public void disable(E commonEntity) {
    commonEntity.disable();
    repository.store(commonEntity);
  }
}
