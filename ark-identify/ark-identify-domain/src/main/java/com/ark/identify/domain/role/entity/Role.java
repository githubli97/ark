package com.ark.identify.domain.role.entity;

import com.ark.base.domain.base.ArkEntity;
import com.ark.base.domain.base.ValueObject;
import com.ark.identify.domain.tenant.entity.TenantId;
import lombok.Getter;

/**
 * 角色，定义
 * 每个租户下最多有64各角色
 * 角色有角色id + 租户id作为唯一约定
 *
 * 一个人可以拥有多个角色，
 * 一个权限也可以被多个角色拥有
 *
 *
 */
@Getter
public class Role extends ValueObject<Role> {
    private RoleId roleId;
    private RoleName roleName;
    private TenantId tenantId;

    Role(RoleId roleId, RoleName roleName, TenantId tenantId) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.tenantId = tenantId;
    }

    @Override
    public boolean sameValueAs(Role other) {
        return roleId.getRoleId().equals(other.getRoleId().getRoleId()) && tenantId.getTenantId().equals(other.getTenantId().getTenantId());
    }
}
