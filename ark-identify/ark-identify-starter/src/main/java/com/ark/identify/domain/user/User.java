package com.ark.identify.domain.user;

import com.ark.identify.domain.role.Permission;
import com.ark.identify.domain.tenant.TenantEntity;

/**
 * 员工领域实体.
 */
public interface User extends TenantEntity, Permission {
  String getPhone();

  String getEmail();

  void updatePhone(String phone);

  void updateEmail(String email);
}
