package com.ark.identify.domain.role;

import com.ark.domain.AbstractCommonEntity;

/**
 * 资源类型值对象.
 */
public class ResourceType extends AbstractCommonEntity {

  private Long tenantId;


  @Override
  protected void assertVerifyName(String name) {
  }
}
