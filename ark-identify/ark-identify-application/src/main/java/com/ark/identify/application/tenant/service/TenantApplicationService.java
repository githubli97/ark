package com.ark.identify.application.tenant.service;

import com.ark.identify.application.tenant.command.SignInByPhoneCommand;

public interface TenantApplicationService {
    /**
     * 手机号注册租户
     */
    void signInByPhone(SignInByPhoneCommand signInByPhoneCommand);
}
