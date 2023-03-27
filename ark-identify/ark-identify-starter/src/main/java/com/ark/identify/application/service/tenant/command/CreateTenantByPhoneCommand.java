package com.ark.identify.application.service.tenant.command;

import lombok.Data;

@Data
public class CreateTenantByPhoneCommand {
    private String phone;
    private String tenantName;
    private String verifyCode;
}
