package com.ark.identify.domain.account.entity;

import com.ark.base.domain.phone.ChinaPhone;
import com.ark.identify.domain.account.entity.password.PasswordAccount;
import com.ark.identify.domain.department.DepartmentId;
import com.ark.identify.domain.department.DepartmentName;
import com.ark.identify.domain.role.entity.Role;
import com.ark.identify.domain.tenant.entity.TenantId;
import com.google.common.collect.Lists;
import lombok.Getter;

import java.util.List;

@Getter
public class PhoneAccount extends PasswordAccount {
    private ChinaPhone chinaPhone;

    PhoneAccount(List<TenantId> tenantIdList, ChinaPhone chinaPhone, DepartmentId departmentId) {
        super(tenantIdList, departmentId);
        this.chinaPhone = chinaPhone;
    }

}
