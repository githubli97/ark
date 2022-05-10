package com.ark.identify.domain.account.entity.phone;

import com.ark.base.domain.phone.ChinaPhone;
import com.ark.identify.domain.account.entity.password.PasswordAccount;
import com.ark.identify.domain.tenant.entity.TenantId;
import com.google.common.collect.Lists;
import lombok.Getter;

import java.util.List;

@Getter
public class PhoneAccount extends PasswordAccount {
    private ChinaPhone chinaPhone;

    private PhoneAccount(List<TenantId> tenantIdList, ChinaPhone chinaPhone) {
        super(tenantIdList);
        this.chinaPhone = chinaPhone;
    }


    public static PhoneAccount phoneAccountRegister(TenantId tenantId, ChinaPhone chinaPhone) {
        PhoneAccount phoneAccount = new PhoneAccount(Lists.newArrayList(tenantId), chinaPhone);
        return phoneAccount;
    }
}
