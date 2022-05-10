package com.ark.identify.application.tenant.service.impl;

import com.ark.ApplicationTest;
import com.ark.identify.application.tenant.command.SignInByPhoneCommand;
import com.ark.identify.application.tenant.service.TenantApplicationService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TenantApplicationServiceImplMockTest extends ApplicationTest {
    @Autowired
    private TenantApplicationService tenantApplicationService;

    @Test
    public void signInByPhone() {
        SignInByPhoneCommand signInByPhoneCommand = new SignInByPhoneCommand();
        signInByPhoneCommand.setPhoneNumber("18888888888");
        signInByPhoneCommand.setTenantName("【方舟】");

        tenantApplicationService.signInByPhone(signInByPhoneCommand);
    }

}
