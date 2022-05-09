package com.ark.identify.application.tenant.service.impl;

import com.ark.identify.application.tenant.command.SignInByPhoneCommand;
import com.ark.identify.application.tenant.service.TenantApplicationService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TenantApplicationServiceImplMockTest {
    public static TenantApplicationService TENANT_APPLICATION_SERVICE = new TenantApplicationServiceImpl();

    @BeforeAll
    public static void beforeAll() {
    }

    @Test
    public void signInByPhone() {
        SignInByPhoneCommand signInByPhoneCommand = new SignInByPhoneCommand();
        signInByPhoneCommand.setPhoneNumber("18888888888");
        signInByPhoneCommand.setTenantName("【方舟】");

        TENANT_APPLICATION_SERVICE.signInByPhone(signInByPhoneCommand);
    }

}
