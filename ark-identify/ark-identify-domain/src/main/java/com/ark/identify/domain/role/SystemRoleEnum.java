package com.ark.identify.domain.role;

import com.ark.identify.domain.role.entity.RoleId;
import com.ark.identify.domain.role.entity.RoleName;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 系统预置角色
 */
@Getter
@AllArgsConstructor
public enum SystemRoleEnum {
    /**
     * 查看租户下所有数据
     */
    TENANT_MANAGER_ROLE(new RoleId(1L), new RoleName("租户管理员")),
    /**
     * 查看当前部门，子部门下数据
     */
    TENANT_DEPARTMENT_MANAGER_ROLE(new RoleId(2L), new RoleName("部门管理员"));

    private RoleId roleId;
    private RoleName roleName;
}
