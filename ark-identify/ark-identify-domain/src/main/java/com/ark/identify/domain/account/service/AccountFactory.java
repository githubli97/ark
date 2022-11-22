package com.ark.identify.domain.account.service;

import com.ark.base.domain.phone.ChinaPhone;
import com.ark.identify.domain.account.entity.Account;
import com.ark.identify.domain.account.entity.valueobject.AccountStatus;
import com.ark.identify.domain.account.entity.valueobject.AccountTenant;
import com.ark.identify.domain.account.entity.valueobject.Password;
import com.ark.identify.domain.department.entity.Department;
import com.ark.identify.domain.tenant.entity.Tenant;
import com.google.common.collect.Lists;

public class AccountFactory {
    public static Account signUpByPhone(Tenant tenant, Department department, String chinaPhone) {
        return new Account()
                .setAccountStatus(AccountStatus.ENABLE)
                .setChinaPhone(new ChinaPhone(chinaPhone))
                .setPassword(new Password(Password.DEFAULT_PASSWORD))
                .setTenantList(Lists.newArrayList(signUp(tenant, department)));
    }

    public static AccountTenant signUp(Tenant tenant, Department department) {
        return new AccountTenant()
                .setTenantId(tenant.getTenantId())
                .setTenantName(tenant.getTenantName().getName())
                .setDepartmentId(department.getDepartmentId())
                .setDepartmentName(department.getDepartmentName().getDepartmentName());
    }
}
