package com.ark.identify.application.tenant.service;

import com.ark.common.dto.Response;
import com.ark.identify.application.tenant.command.SignInByPhoneCommand;

public interface TenantApplicationService {
    /**
     * 创建租户
     * 创建管理员角色
     * 手机号注册租户管理员账户
     *
     * 登录
     */
    Response signInByPhone(SignInByPhoneCommand signInByPhoneCommand);
}
