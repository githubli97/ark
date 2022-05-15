package com.ark.identify.domain.role.entity;

import com.ark.identify.domain.role.SystemRoleEnum;
import com.ark.identify.domain.tenant.entity.TenantId;

public class RoleFactory {

//    private RoleRepository roleRepository;
//
//    public RoleFactory() {
//        roleRepository = ApplicationContextHelper.getBean(RoleRepository.class);
//    }

    /**
     * 租户初始化，创建租户管理员
     */
    public static Role createTenantManager(TenantId tenantId) {
        Role role = new Role(SystemRoleEnum.TENANT_MANAGER_ROLE, tenantId);
        return role;
    }
}
