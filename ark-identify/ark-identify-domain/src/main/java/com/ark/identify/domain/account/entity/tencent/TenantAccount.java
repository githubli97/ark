package com.ark.identify.domain.account.entity.tencent;

import com.ark.identify.domain.account.entity.Account;
import com.ark.identify.domain.tenant.entity.TenantId;
import lombok.Getter;

@Getter
public abstract class TenantAccount extends Account {
    private TenantId tenantId;

    public TenantAccount(TenantId tenantId) {
        super();
        this.tenantId = tenantId;
    }
}
