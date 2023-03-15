package com.ark.identify.application.service.command;

import lombok.Data;

@Data
public class SignInBySmsCommand {
    /**
     * 用户名
     */
    private String account;
    /**
     * sms
     */
    private String code;
}
