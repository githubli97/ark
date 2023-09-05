package com.ark.core.base;

import java.time.LocalDateTime;

/**
 * 可记录时间抽象.
 */
public interface BaseTimeAble {
  /**
   * 获取创建时间.
   *
   * @return 创建时间
   */
  LocalDateTime getCreateTime();

  /**
   * 设置创建时间.
   *
   * @param createTime 创建时间
   */
  void setCreateTime(LocalDateTime createTime);

  /**
   * 获取更新时间.
   *
   * @return 更新时间
   */
  LocalDateTime getUpdateTime();

  /**
   * 设置更新时间.
   *
   * @param updateTime 更新时间
   */
  void setUpdateTime(LocalDateTime updateTime);
}
