package com.ark.identify.domain.role;

import com.ark.common.domain.tag.TagEntity;
import com.ark.identify.domain.tenant.TenantEntity;

/**
 * 资源, 权限.
 */
public interface Permission extends TenantEntity, TagEntity {
}