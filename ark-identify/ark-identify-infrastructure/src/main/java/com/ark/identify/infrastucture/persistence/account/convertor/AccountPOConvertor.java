package com.ark.identify.infrastucture.persistence.account.convertor;

import com.ark.base.convertor.Convertor;
import com.ark.identify.domain.account.entity.phone.PhoneAccount;
import com.ark.identify.infrastucture.persistence.account.model.AccountPO;
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
public class AccountPOConvertor implements Convertor<PhoneAccount, AccountPO> {
    @Override
    public AccountPO DOToPO(PhoneAccount DO) {
        AccountPO accountPO = new AccountPO().setCreater(Long.parseLong(DO.getCreater().getOperatorId()))
                .setModifier(Long.parseLong(DO.getModifier().getOperatorId()))
                .setCreateTime(DO.getCreateTime())
                .setModifyTime(DO.getModifyTime())
                .setPassword(DO.getPassword().getPassword())
                .setTenantId(DO.getTenantId().getTenantId())
                .setUserName(DO.getUserName().getUserName())
                .setPhoneNumber(DO.getChinaPhone().getPhoneNumber())
                .setAccountStatus(DO.getAccountStatus().getCode());
        return accountPO;
    }
}
