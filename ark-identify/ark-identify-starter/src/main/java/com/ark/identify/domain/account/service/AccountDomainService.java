package com.ark.identify.domain.account.service;

import com.ark.identify.domain.account.entity.Account;
import com.ark.identify.domain.department.entity.Department;
import com.ark.identify.domain.tenant.entity.Tenant;

/**
 * @Classname AccountDomainService
 * @Description AccountDomainService
 * @Date 2022/11/21 20:08
 * @Created by hang.li
 */
public interface AccountDomainService {
    Account phoneAccountRegister(Tenant tenant, Department department, String chinaPhone);

    Account getByPhone(String username);
}
