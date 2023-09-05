package com.ark.identify.domain.tenant;

import com.ark.core.base.BaseCommonEntity;

/**
 * 租户实体.
 */
public interface TenantEntity extends BaseCommonEntity {
  Tenant getTenant();

  void setTenant(Tenant tenant);
}