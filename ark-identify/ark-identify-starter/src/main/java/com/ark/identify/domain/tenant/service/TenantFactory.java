package com.ark.identify.domain.tenant.service;

import com.ark.identify.domain.tenant.entity.Tenant;
import com.ark.identify.domain.tenant.entity.valueobject.TenantName;
import com.ark.identify.domain.tenant.entity.valueobject.TenantStatus;
import lombok.Getter;

@Getter
public class TenantFactory {
    public static Tenant register(String tenantName) {
        Tenant tenant = new Tenant();
        tenant.setTenantName(new TenantName(tenantName))
                .setTenantStatus(TenantStatus.Enable);
        return tenant;
    }
}
