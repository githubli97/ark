package com.ark.identify.domain.tenant.entity;

import com.ark.base.domain.base.ArkEntity;
import com.ark.identify.domain.tenant.entity.valueobject.TenantName;
import com.ark.identify.domain.tenant.entity.valueobject.TenantStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Tenant extends ArkEntity<Tenant> {
    private Long tenantId;
    private TenantName tenantName;
    private TenantStatus tenantStatus;
}
