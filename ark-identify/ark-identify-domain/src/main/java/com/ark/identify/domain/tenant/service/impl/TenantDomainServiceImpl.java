package com.ark.identify.domain.tenant.service.impl;

import com.ark.identify.domain.tenant.entity.Tenant;
import com.ark.identify.domain.tenant.repository.TenantRepository;
import com.ark.identify.domain.tenant.service.TenantDomainService;
import com.ark.identify.domain.tenant.service.TenantFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TenantDomainServiceImpl implements TenantDomainService {
    @Autowired
    private TenantRepository tenantRepository;
    @Override
    public Tenant registerTenant(String tenantName) {
        Tenant tenant = TenantFactory.register(tenantName);
        return tenantRepository.store(tenant);
    }
}
