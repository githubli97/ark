package com.ark.identify.domain.tenant.entity;

import com.ark.base.domain.base.ArkEntity;
import lombok.Getter;

@Getter
public class Tenant extends ArkEntity<Tenant> {
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

    /**
     * 用于持久化后回写id
     */
    public void setTenantId(TenantId tenantId) {
        this.tenantId = tenantId;
    }

    @Override
    public boolean sameIdentityAs(Tenant other) {
        return tenantId.equals(other.getTenantId());
    }
}
