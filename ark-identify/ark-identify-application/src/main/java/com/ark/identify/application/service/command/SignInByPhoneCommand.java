package com.ark.identify.application.service.command;

import com.ark.base.domain.phone.ChinaPhone;

public class SignInByPhoneCommand {
    private String phoneNumber;
    private String tenantName;

    private ChinaPhone chinaPhone;

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
