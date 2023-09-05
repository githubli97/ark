package com.ark.identify.infrastructure.tenant;

import com.ark.identify.domain.tenant.Tenant;
import com.ark.identify.domain.tenant.TenantRepository;
import com.ark.infrastructure.base.RepositoryImpl;
import org.springframework.stereotype.Service;

/**
 * Repository 基类.
 */
@Service
public class TenantRepositoryImpl extends RepositoryImpl<Tenant, TenantPo> implements
    TenantRepository {
}
