package com.ark.identify.application.service.impl;

import com.ark.identify.domain.account.entity.Account;
import com.ark.identify.domain.department.service.DepartmentDomainService;
import com.ark.identify.application.service.command.SignInByPhoneCommand;
import com.ark.common.dto.Response;
import com.ark.identify.application.service.TenantApplicationService;
import com.ark.identify.domain.account.service.AccountDomainService;
import com.ark.identify.domain.department.entity.Department;
import com.ark.identify.domain.department.entity.valueobject.DeptartmentTenant;
import com.ark.identify.domain.tenant.entity.Tenant;
import com.ark.identify.domain.tenant.service.TenantDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TenantApplicationServiceImpl implements TenantApplicationService {
    @Autowired
    private TenantDomainService tenantDomainService;
    @Autowired
    private AccountDomainService accountDomainService;
    @Autowired
    private DepartmentDomainService departmentDomainService;

    /**
     * 创建租户
     * 创建管理员角色
     * 手机号注册租户管理员账户
     *
     * 登录
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Response signUpByPhone(SignInByPhoneCommand signInByPhoneCommand) {
        // 保存租户
        Tenant tenant = tenantDomainService.registerTenant(signInByPhoneCommand.getTenantName());

        // 创建根部门
        Department rootDepartment = departmentDomainService.createTenantRootDepartment(DeptartmentTenant.convertThis(tenant));

        // 保存用户
        Account account = accountDomainService.phoneAccountRegister(tenant, rootDepartment, signInByPhoneCommand.getPhoneNumber());
        return Response.ok();
    }
}
