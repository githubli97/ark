package com.ark.identify.domain.tenant.service;

import com.ark.identify.domain.tenant.entity.Tenant;

public interface TenantDomainService {
    Tenant registerTenant(String tenantName);
}
