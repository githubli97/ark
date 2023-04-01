package com.ark.identify.domain.organiztion;

import com.ark.domain.AbstractNameableEntity;

/**
 * 组织实体.
 */
public class Organization extends AbstractNameableEntity {

  private Employee manager;

  @Override
  protected void assertVerifyName(String name) {
  }
}
