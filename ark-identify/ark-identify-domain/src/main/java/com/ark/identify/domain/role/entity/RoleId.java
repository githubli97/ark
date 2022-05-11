package com.ark.identify.domain.role.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RoleId {
    public static final long TENANT_MANAGER_ROLE_ID = 1L;

    private Long roleId;
}
