package com.ark.identify.domain.account.entity;

import com.ark.base.domain.helper.ApplicationContextHelper;
import com.ark.base.domain.phone.ChinaPhone;
import com.ark.identify.domain.account.repository.AccountRepository;
import com.ark.identify.domain.role.entity.Role;
import com.ark.identify.domain.tenant.entity.TenantId;
import com.google.common.collect.Lists;

public class AccountFactory {
    private AccountRepository accountRepository;

    public AccountFactory() {
        accountRepository = ApplicationContextHelper.getBean(AccountRepository.class);
    }


    public static PhoneAccount phoneAccountRegister(TenantId tenantId, ChinaPhone chinaPhone, Role role) {
        PhoneAccount phoneAccount = new PhoneAccount(Lists.newArrayList(tenantId), chinaPhone);
        phoneAccount.setRoleList(Lists.newArrayList(role));
        return phoneAccount;
    }
}
