package com.ark.identify.domain.role;

import com.ark.core.tag.TagEntity;
import com.ark.identify.domain.tenant.TenantEntity;
import java.util.List;

/**
 * 角色.
 */
public interface Role extends TenantEntity, TagEntity {
  /**
   * 为角色分配权限.
   */
  void setPermissions(List<Permission> permissions);
}
