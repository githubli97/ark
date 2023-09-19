package com.ark.common.domain;

/**
 * 可记录id抽象.
 */
public interface BaseIdAble {
  /**
   * 获取id.
   *
   * @return id
   */
  Long getId();

  /**
   * 设置id.
   *
   * @param id id
   */
  void setId(long id);
}
