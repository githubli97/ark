package com.ark.identify.application.tenant.command;

import com.ark.base.domain.phone.ChinaPhone;
import com.ark.identify.domain.account.entity.phone.PhoneAccount;
import com.ark.identify.domain.tenant.entity.Tenant;
import com.ark.identify.domain.tenant.entity.TenantName;

public class SignInByPhoneCommand {
    private String phoneNumber;
    private String tenantName;

    private Tenant tenant;
    private ChinaPhone chinaPhone;

    public Tenant converTenant() {
        if (tenant == null) {
            tenant = Tenant.register(new TenantName(tenantName));
        }
        return tenant;
    }

    public ChinaPhone converChinaPhone() {
        if (chinaPhone == null) {
            chinaPhone = new ChinaPhone(phoneNumber);
        }
        return chinaPhone;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public SignInByPhoneCommand setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getTenantName() {
        return tenantName;
    }

    public SignInByPhoneCommand setTenantName(String tenantName) {
        this.tenantName = tenantName;
        return this;
    }
}
