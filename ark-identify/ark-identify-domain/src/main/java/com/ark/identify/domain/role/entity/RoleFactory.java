package com.ark.identify.domain.role.entity;

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
        Role role = new Role(new RoleId(RoleId.TENANT_MANAGER_ROLE_ID), new RoleName("租户管理员"), tenantId);
        return role;
    }
}
