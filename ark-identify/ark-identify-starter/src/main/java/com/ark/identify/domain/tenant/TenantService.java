package com.ark.identify.domain.tenant;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TenantService {

  private TenantRepository iTenantRepository;

  public Tenant store(Tenant tenant) {
    return iTenantRepository.store(tenant);
  }
}
