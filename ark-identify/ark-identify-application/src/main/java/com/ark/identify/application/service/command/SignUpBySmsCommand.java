package com.ark.identify.application.service.command;

import lombok.Data;

@Data
public class SignUpBySmsCommand {
    private String phoneNumber;
    private String tenantName;
    private String smsCode;
}
