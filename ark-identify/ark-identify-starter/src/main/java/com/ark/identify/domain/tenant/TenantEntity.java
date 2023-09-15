package com.ark.identify.domain.tenant;

import com.ark.core.ddd.Entity;

/**
 * 租户实体.
 */
public interface TenantEntity extends Entity {
  Tenant getTenant();

  void setTenant(Tenant tenant);
}