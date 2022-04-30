package com.ark.identify.domain.tenant.repository;

import com.ark.identify.domain.tenant.entity.Tenant;

public interface TenantRepository {
    /**
     * 保存租户，并返回主键
     */
    Tenant save(Tenant tenant);
}
