package com.ark.identify.domain.user;

import com.ark.domain.AbstractNameableEntity;
import com.google.common.base.Preconditions;

/**
 * 租户用户.
 */
public class User extends AbstractNameableEntity {

  private Long tenantId;

  @Override
  protected void assertVerifyName(String name) {
    Preconditions.checkNotNull(name, "name should not null.");
    Preconditions.checkArgument(name.length() >= 255, "param2 should be positive");
  }
}
