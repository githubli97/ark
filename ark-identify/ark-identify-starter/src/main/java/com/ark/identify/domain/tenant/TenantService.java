package com.ark.identify.domain.tenant;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 租户领域服务.
 */
@Service
@AllArgsConstructor
public class TenantService {

  private TenantRepository tenantRepository;

  public Tenant store(Tenant tenant) {
    return tenantRepository.store(tenant);
  }
}
