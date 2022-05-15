package com.ark.identify.domain.account.entity.tenant;

import com.ark.identify.domain.account.entity.Account;
import com.ark.identify.domain.department.DepartmentId;
import com.ark.identify.domain.tenant.entity.Tenant;
import com.ark.identify.domain.tenant.entity.TenantId;
import lombok.Getter;

import java.util.List;

@Getter
public abstract class TenantAccount extends Account {
    private List<TenantId> tenantIdList;
    private DepartmentId departmentId;

    public TenantAccount(List<TenantId> tenantIdList, DepartmentId departmentId) {
        super();
        this.tenantIdList = tenantIdList;
        this.departmentId = departmentId;
    }
}
