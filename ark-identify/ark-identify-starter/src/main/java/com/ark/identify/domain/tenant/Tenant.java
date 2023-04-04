package com.ark.identify.domain.tenant;

import com.ark.domain.AbstractCommonEntity;
import com.google.common.base.Preconditions;

/**
 * 租户实体.
 */

public class Tenant extends AbstractCommonEntity {
  @Override
  protected void assertVerifyName(String name) {
    // 租户名称小于100个字符
    Preconditions.checkNotNull(name);
    Preconditions.checkArgument(name.length() < 100, "租户名称应该小于100个字符", name);
  }
}
