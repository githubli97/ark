package com.ark.identify.infrastructure.tenant;

import com.ark.identify.domain.tenant.Tenant;
import com.ark.infrastructure.base.AbstractPersistent;
import lombok.Data;

@Data
public class TenantPO extends AbstractPersistent<Tenant> {
    private String name;
}
