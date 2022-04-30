package com.ark.identify.domain.tenant.entity;

import lombok.Getter;

@Getter
public class Tenant {
    private TenantId tenantId;
    private TenantName tenantName;
    private TenantStatus tenantStatus;

    private Tenant() {

    }

    public static Tenant register(TenantName tenantName) {
        Tenant tenant = new Tenant();
        tenant.tenantName = tenantName;
        tenant.tenantStatus = TenantStatus.Enable;
        return tenant;
    }
}
