package com.ark.identify.application.tenant.service.impl;

import com.ark.identify.application.tenant.command.SignInByPhoneCommand;
import com.ark.identify.application.tenant.service.TenantApplicationService;
import com.ark.identify.domain.account.entity.AccountFactory;
import com.ark.identify.domain.account.entity.PhoneAccount;
import com.ark.identify.domain.account.repository.AccountRepository;
import com.ark.identify.domain.role.entity.Role;
import com.ark.identify.domain.role.entity.RoleFactory;
import com.ark.identify.domain.role.repository.RoleRepository;
import com.ark.identify.domain.tenant.entity.Tenant;
import com.ark.identify.domain.tenant.repository.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TenantApplicationServiceImpl implements TenantApplicationService {
    @Autowired
    private TenantRepository tenantRepository;
    @Autowired
    private AccountRepository phoneAccountRepository;
    @Autowired
    private RoleRepository roleRepository;

    /**
     * 创建租户
     * 创建管理员角色
     * 手机号注册租户管理员账户
     *
     * 登录
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void signInByPhone(SignInByPhoneCommand signInByPhoneCommand) {
        // 保存租户
        Tenant tenant = signInByPhoneCommand.converTenant();
        tenantRepository.store(tenant);
        // 创建角色
        Role tenantManager = RoleFactory.createTenantManager(tenant.getTenantId());
        roleRepository.store(tenantManager);
        // 保存用户
        PhoneAccount phoneAccount = AccountFactory.phoneAccountRegister(tenant.getTenantId(), signInByPhoneCommand.converChinaPhone(), tenantManager);
        phoneAccountRepository.store(phoneAccount);
    }
}
