package com.ark.core.common.domain;

/**
 * 可乐观锁维护数据状态.
 */
public interface BaseVersionAble {
  long getVersion();

  void setVersion(long version);
}
