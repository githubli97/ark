package com.ark.identify.infrastucture.persistence.tenant.convertor;

import com.ark.base.convertor.Convertor;
import com.ark.identify.domain.account.entity.phone.PhoneAccount;
import com.ark.identify.domain.tenant.entity.Tenant;
import com.ark.identify.infrastucture.persistence.account.model.AccountPO;
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
                .setCreater(Long.parseLong(DO.getCreater().getOperatorId()))
                .setModifier(Long.parseLong(DO.getModifier().getOperatorId()))
                .setCreateTime(DO.getCreateTime())
                .setModifyTime(DO.getModifyTime())
                .setTenantName(DO.getTenantName().getName())
                .setTenantStatus(DO.getTenantStatus().getCode());
    }
}
