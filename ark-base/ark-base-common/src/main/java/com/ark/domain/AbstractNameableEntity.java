package com.ark.domain;

/**
 * 抽象可命名实体.
 * 包含实体对象名称.
 */
public abstract class AbstractNameableEntity extends AbstractEntity {

  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    assertVerifyName(name);
    this.name = name;
  }

  protected abstract void assertVerifyName(String name);
}
