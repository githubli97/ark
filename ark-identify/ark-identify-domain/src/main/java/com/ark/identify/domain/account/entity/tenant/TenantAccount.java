package com.ark.identify.domain.account.entity.tenant;

import com.ark.identify.domain.account.entity.Account;
import com.ark.identify.domain.tenant.entity.Tenant;
import com.ark.identify.domain.tenant.entity.TenantId;
import lombok.Getter;

import java.util.List;

@Getter
public abstract class TenantAccount extends Account {
    private List<TenantId> tenantIdList;

    public TenantAccount(List<TenantId> tenantIdList) {
        super();
        this.tenantIdList = tenantIdList;
    }
}
