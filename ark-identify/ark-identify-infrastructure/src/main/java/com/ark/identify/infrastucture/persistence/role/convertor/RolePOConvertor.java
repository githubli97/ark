package com.ark.identify.infrastucture.persistence.role.convertor;

import com.ark.base.convertor.Convertor;
import com.ark.identify.domain.account.entity.PhoneAccount;
import com.ark.identify.domain.role.entity.Role;
import com.ark.identify.infrastucture.persistence.account.model.AccountPO;
import com.ark.identify.infrastucture.persistence.role.model.RolePO;
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
public class RolePOConvertor implements Convertor<Role, RolePO> {
    @Override
    public RolePO DOToPO(Role DO) {
        RolePO rolePO = new RolePO().setCreater(Long.parseLong(DO.getCreater().getOperatorId()))
                .setModifier(Long.parseLong(DO.getModifier().getOperatorId()))
                .setCreateTime(DO.getCreateTime())
                .setModifyTime(DO.getModifyTime())
                .setRoleId(DO.getRoleId().getRoleId())
                .setTenantId(DO.getTenantId().getTenantId());
        return rolePO;
    }
}
