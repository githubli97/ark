package com.ark.core.common.domain;

/**
 * 可禁用启用抽象.
 */
public interface BaseDisableAble {
  void enable();

  void disable();

  boolean isEnabled();
}
