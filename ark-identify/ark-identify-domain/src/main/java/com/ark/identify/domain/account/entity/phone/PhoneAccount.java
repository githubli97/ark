package com.ark.identify.domain.account.entity.phone;

import com.ark.base.domain.phone.ChinaPhone;
import com.ark.identify.domain.account.entity.password.PasswordAccount;
import com.ark.identify.domain.tenant.entity.TenantId;
import lombok.Getter;

@Getter
public class PhoneAccount extends PasswordAccount {
    private ChinaPhone chinaPhone;

    private PhoneAccount(TenantId tenantId, ChinaPhone chinaPhone) {
        super(tenantId);
        this.chinaPhone = chinaPhone;
    }


    public static PhoneAccount phoneAccountRegister(TenantId tenantId, ChinaPhone chinaPhone) {
        PhoneAccount phoneAccount = new PhoneAccount(tenantId, chinaPhone);
        return phoneAccount;
    }
}
