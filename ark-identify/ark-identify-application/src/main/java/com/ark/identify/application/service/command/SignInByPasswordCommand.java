package com.ark.identify.application.service.command;

import lombok.Data;

@Data
public class SignInByPasswordCommand {
    /**
     * 用户名
     */
    private String account;
    /**
     * 密码
     */
    private String password;
}
