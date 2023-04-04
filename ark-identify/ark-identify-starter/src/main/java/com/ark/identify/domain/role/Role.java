package com.ark.identify.domain.role;

import com.ark.domain.AbstractCommonEntity;
import java.util.List;

/**
 * 角色实体.
 */
public class Role extends AbstractCommonEntity {

  private Long tenantId;
  private List<Resource> resourceList;

  @Override
  protected void assertVerifyName(String name) {
  }
}
