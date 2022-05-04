package com.ark.identify.application.tenant.service.impl;

import com.ark.identify.application.tenant.command.SignInByPhoneCommand;
import com.ark.identify.application.tenant.service.TenantApplicationService;
import com.ark.identify.domain.account.repository.PhoneAccountRepository;
import com.ark.identify.domain.account.entity.phone.PhoneAccount;
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
    private PhoneAccountRepository phoneAccountRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void signInByPhone(SignInByPhoneCommand signInByPhoneCommand) {
        // 保存租户
        Tenant tenant = signInByPhoneCommand.getTenant();
        tenantRepository.store(tenant);
        // 保存用户
        PhoneAccount phoneAccount = PhoneAccount.phoneAccountRegister(tenant.getTenantId(), signInByPhoneCommand.getChinaPhone());
        phoneAccountRepository.store(phoneAccount);
    }
}
