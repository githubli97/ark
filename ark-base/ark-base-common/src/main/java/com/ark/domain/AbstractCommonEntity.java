package com.ark.domain;

import com.google.common.base.Preconditions;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 抽象可命名, 可禁用的通用实体, 实体可以选择继承.
 */
@Getter
public abstract class AbstractCommonEntity extends AbstractEntity {

  protected String name;
  protected Boolean enabled;

  public void setName(String name) {
    assertVerifyName(name);
    this.name = name;
  }

  /**
   * 子类实现,用于校验名称.
   *
   * @param name 实体名称
   */
  protected abstract void assertVerifyName(String name);

  public void enable() {
    Preconditions.checkArgument(getEnabled(), "当前组织已为启用状态");
    enabled = Boolean.TRUE;
  }

  public void disable() {
    Preconditions.checkArgument(getEnabled(), "当前组织已为禁用状态");
    enabled = Boolean.FALSE;
  }
}
