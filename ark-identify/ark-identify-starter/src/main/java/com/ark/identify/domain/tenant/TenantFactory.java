package com.ark.identify.domain.tenant;

import org.springframework.stereotype.Service;

@Service
public class TenantFactory {

    public Tenant createTenant(String name) {
        Tenant tenant = new Tenant();

        tenant.setName(name);
        return tenant;
    }
}
