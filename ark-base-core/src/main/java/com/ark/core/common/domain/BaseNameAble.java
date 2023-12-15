package com.ark.core.common.domain;

/**
 * 可命名抽象.
 */
public interface BaseNameAble {

  /**
   * 获取名称.
   *
   * @return 名称
   */
  String getName();

  /**
   * 设置名称.
   *
   * @param name 名称
   */
  void setName(String name);

  /**
   * 获取描述.
   *
   * @return 描述
   */
  String getDesc();

  /**
   * 设置描述.
   *
   * @param desc 描述
   */
  void setDesc(String desc);
}