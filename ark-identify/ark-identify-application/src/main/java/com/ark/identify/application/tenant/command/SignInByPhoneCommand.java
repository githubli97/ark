package com.ark.identify.application.tenant.command;

import com.ark.common.domain.ChinaPhone;
import com.ark.identify.domain.account.entity.phone.PhoneAccount;
import com.ark.identify.domain.tenant.entity.Tenant;
import com.ark.identify.domain.tenant.entity.TenantName;

public class SignInByPhoneCommand {
    private String phoneNumber;
    private String tenantName;

    private Tenant tenant;
    private ChinaPhone chinaPhone;
    private PhoneAccount phoneAccount;

    public Tenant getTenant() {
        if (tenant == null) {
            tenant = Tenant.register(new TenantName(tenantName));
        }
        return tenant;
    }

    public ChinaPhone getChinaPhone() {
        if (chinaPhone == null) {
            chinaPhone = new ChinaPhone(phoneNumber);
        }
        return chinaPhone;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }
}
