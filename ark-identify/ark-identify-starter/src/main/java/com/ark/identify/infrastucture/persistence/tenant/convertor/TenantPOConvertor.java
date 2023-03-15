package com.ark.identify.infrastucture.persistence.tenant.convertor;

import com.ark.infrastructure.convertor.Convertor;
import com.ark.identify.domain.tenant.entity.Tenant;
import com.ark.identify.infrastucture.persistence.tenant.model.TenantPO;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * </p>
 *
 * @author lihang
 * @since 2022-05-09
 */
@Component
public class TenantPOConvertor implements Convertor<Tenant, TenantPO> {
    @Override
    public TenantPO DOToPO(Tenant DO) {
        return new TenantPO()
                .setTenantName(DO.getTenantName().getName())
                .setTenantStatus(DO.getTenantStatus().getCode());
    }

    @Override
    public Tenant POToDO(TenantPO PO) {
        return null;
    }
}
