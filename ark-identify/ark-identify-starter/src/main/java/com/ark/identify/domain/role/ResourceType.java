package com.ark.identify.domain.role;

import com.ark.domain.AbstractNameableEntity;

/**
 * 资源类型值对象.
 */
public class ResourceType extends AbstractNameableEntity {

  private Long tenantId;


  @Override
  protected void assertVerifyName(String name) {
  }
}
