package com.ark.identify.infrastructure.tenant;

import com.ark.identify.domain.tenant.Tenant;
import com.ark.infrastructure.base.Convertor;
import org.springframework.stereotype.Component;

@Component
public class TenantConvertor implements Convertor<Tenant, TenantPO> {

    @Override
    public TenantPO getPOInstance() {
        return new TenantPO();
    }

    @Override
    public TenantPO doDOToPO(TenantPO PO, Tenant DO) {
        PO.setName(DO.getName());
        return PO;
    }

    @Override
    public Tenant POToDO(TenantPO PO) {
        return null;
    }
}
