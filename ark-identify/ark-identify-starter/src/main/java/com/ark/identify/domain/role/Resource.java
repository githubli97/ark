package com.ark.identify.domain.role;

import com.ark.domain.AbstractCommonEntity;

/**
 * 抽象权限资源管理实体.
 */
public abstract class Resource extends AbstractCommonEntity {

  private Long tenantId;
  private ResourceType resourceType;
}
